package com.weather.utils;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public class HtmlParser {

    static final Logger LOGGER = Logger.getLogger(HtmlParser.class);

    public static Document getPageSource(String url) throws IOException {
        LOGGER.info("GET HTML by url: " + url);
        return Jsoup.parse(new URL(url), 1000);
    }

    public static Element getElement(Document document, String key){
        Element element = document.body();
        return element.getElementById(key);
    }
}
