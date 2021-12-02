package com.example.lab5.service;


import com.example.lab5.LocalBusiness;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import ezvcard.VCard;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ApiService {
    private static final String URI = "https://panoramafirm.pl/";
    private static final String CSS_QUERY = "script";
    private static String TYPE_ELEMENT = "application/ld+json";
    private final ObjectMapper objectMapper;

    public StringBuilder getVCard(String searchTerm) throws IOException {

        String searchURI = URI + searchTerm;
        Elements elementsFromWebsite = getElementsFromHtml(searchURI);
        List<LocalBusiness> localBusinesses = createListOfLocalBusiness(elementsFromWebsite);
       return generateHtml(localBusinesses);
    }

    Elements getElementsFromHtml(String searchURI) throws IOException {
        Document document = Jsoup.connect(searchURI).get();
        Elements elements = document.select(CSS_QUERY);
        Elements result = new Elements();
        for (Element element : elements) {
            if (element.attr("type").equals(TYPE_ELEMENT)) {
                result.add(element);
            }
        }
        result.remove(elements.last());
        return result;
    }

    List<LocalBusiness> createListOfLocalBusiness(Elements elementsFromWebsite) {
        Gson gson = new Gson();
        List<LocalBusiness> localBusinesses = new ArrayList<>();
        for (Element e : elementsFromWebsite) {
            LocalBusiness localBusiness = gson.fromJson(e.data(), LocalBusiness.class);
            localBusinesses.add(localBusiness);
        }

        return localBusinesses;
    }

    VCard createVCard(LocalBusiness localBusiness) {
        VCard vCard = new VCard();
        vCard.addTitle(localBusiness.getName());
        vCard.setFormattedName(localBusiness.getName());
        vCard.addEmail(localBusiness.getEmail());
        vCard.addTelephoneNumber(localBusiness.getTelephone());
        vCard.addUrl(localBusiness.getSameAs());
        return vCard;
    }

    public StringBuilder generateHtml(List<LocalBusiness> localBusinesses){

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Service Worker Toolbox</title>\n" +
                "  </head>\n" +
                "<style>ol {\n" +
                "  background: #ff9999;\n" +
                "  padding: 20px;\n" +
                "}\n" +
                "\n" +
                "ul {\n" +
                "  background: #3399ff;\n" +
                "  padding: 20px;\n" +
                "}\n" +
                "\n" +
                "ol li {\n" +
                "  background: #ffe5e5;\n" +
                "  padding: 5px;\n" +
                "  margin-left: 35px;\n" +
                "}\n" +
                "\n" +
                "ul li {\n" +
                "  background: #cce5ff;\n" +
                "  margin: 5px;\n" +
                "}</style>"+
                "  <body>\n" );
        StringBuilder help=new StringBuilder();
        for(LocalBusiness b:localBusinesses)
        {
            help.append(String.format(
                    "    <ul>" +
                            "<li>Imie: %s \n </li>",b.getName()));
        }
        stringBuilder.append(help);
        stringBuilder.append( "</html>");
        return stringBuilder;
    }

}
