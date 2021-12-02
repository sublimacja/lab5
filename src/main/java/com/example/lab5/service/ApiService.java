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

    public String getVCard(String searchTerm) throws IOException {

        String searchURI = URI + searchTerm;
        Elements elementsFromWebsite = getElementsFromHtml(searchURI);
        List<LocalBusiness> localBusinesses = createListOfLocalBusiness(elementsFromWebsite);
        for (LocalBusiness l : localBusinesses) {
            System.out.println(l.toString());
        }
        return "Test";
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


}
