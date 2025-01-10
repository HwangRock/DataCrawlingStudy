package com.example.crawlingstudy.controller;

import com.example.crawlingstudy.dto.ResponseDTO;
import com.example.crawlingstudy.service.CrawlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlingController {
    @Autowired
    private CrawlingService crawlingService;

    @GetMapping("/crawling")
    public ResponseDTO<String> crawling(@RequestParam String url) {
        return crawlingService.crawlwebsite(url);
    }
}
