package com.example.crawlingstudy.service;

import com.example.crawlingstudy.dto.ResponseDTO;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.regex.*;


@Service
public class CrawlingService {
    public ResponseDTO crawlwebsite(String url){
        try{
            Document doc=Jsoup.connect(url).get();

            String ptag=doc.select("p").text(); //<p> 만을 불러옴.
            String pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"; // 이메일 형식을 확인하기 위한 패턴

            Pattern pat=Pattern.compile(pattern); //패턴을 객체화
            Matcher mat=pat.matcher(ptag); // 가져온 문자열에 원하는 패턴이 있는지 확인

            List l=new ArrayList(); // 발견된 이메일을 저장할 리스트

            while(mat.find()){
                l.add(mat.group()); // 패턴을 발견하면 l에 저장
            }

            return ResponseDTO.<String>builder()
                    .statusCode(200)
                    .data(l)
                    .build();

        }catch(Exception e){
            return ResponseDTO.<String>builder()
                    .statusCode(500)
                    .error("failed to crawl website: "+e.getMessage())
                    .build();
        }
    }
}

