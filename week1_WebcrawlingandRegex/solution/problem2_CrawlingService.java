package com.example.crawlingstudy.service;

import com.example.crawlingstudy.dto.ResponseDTO;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CrawlingService {
    public ResponseDTO crawlwebsite(String url){
        try {
            Document doc = Jsoup.connect(url).get();
            String header = doc.select("h1").text();

            String pid = doc.select("p[id=description]").text();

            Elements pclass = doc.select("p[class=info]");

            List ans = new ArrayList();
            ans.add(header);
            ans.add(pid);
            int fin = pclass.size();
            for (int i = 0; i < fin; i++) {
                ans.add(pclass.get(i).text());
            }

            return ResponseDTO.<String>builder()
                    .data(ans)
                    .statusCode(200)
                    .build();
        }catch (IOException e){
            return ResponseDTO.<String>builder()
                    .statusCode(500)
                    .error("Failed to crawl the website: " + e.getMessage())
                    .build();
        }
    }
}

