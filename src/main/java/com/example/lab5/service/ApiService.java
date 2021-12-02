package com.example.lab5.service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class ApiService {
    private static final String URI = "https://panoramafirm.pl/";
    private static final String CSS_QUERY = "script";
    private static String TYPE_ELEMENT="application/ld+json";

    public String getVCard(String searchTerm) throws IOException {
        String searchURI = URI + searchTerm;
        Elements elementsFromWebsite=getElementsFromHtml(searchURI);
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
}
