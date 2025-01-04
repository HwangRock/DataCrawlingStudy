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
        try{
            Document doc=Jsoup.connect(url).get();

            Elements trTag=doc.select("tr"); //<tr> 태그의 데이터를 먼저 가져옴.

            List<List<String>>tableData=new ArrayList<>();
            int fin=trTag.size();

            for(int i=0;i<fin;i++){
                Elements tdTag=trTag.get(i).select("td"); // 해당 <tr> 태그의 데이터 내부의 <td> 데이터를 가져옴.
                Elements thTag=trTag.get(i).select("th");
                int fin2=tdTag.size();
                int fin3=thTag.size();
                List<String>rowData=new ArrayList<>();
                if(fin2>0){
                    for(int j=0;j<fin2;j++){
                        rowData.add(tdTag.get(j).text()); // <td> 태그의 데이터들을 전부 담음.
                    }
                }
                if(fin3>0){
                    for(int j=0;j<fin3;j++){
                        rowData.add(thTag.get(j).text()); // <th> 태그의 데이터들을 전부 담음.
                    }
                }
                tableData.add(rowData);
            }

            return ResponseDTO.<String>builder()
                    .statusCode(200)
                    .data(tableData)
                    .build();

        }catch(Exception e){
            return ResponseDTO.<String>builder()
                    .statusCode(500)
                    .error("failed to crawl website: "+e.getMessage())
                    .build();
        }
    }
}

