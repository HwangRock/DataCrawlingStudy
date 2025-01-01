package com.example.crawlingstudy.service;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

@Service
public class CrawlingService {
    public String crawlwebsite(String url){
        try{
            Document doc= Jsoup.connect(url).get();
            String title=doc.title();
            String header=doc.selectFirst("h1").text();

            Element linkElement = doc.selectFirst("a");
            String link=linkElement.attr("href");

            return "title: "+title+"\n"
                    +"header: "+header+"\n"+
                    "link: "+link;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

