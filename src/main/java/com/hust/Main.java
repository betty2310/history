package com.hust;

import com.hust.crawler.CrawlData;
import com.hust.historical.History;
import com.hust.process.Process;

public class Main {
    public static void main(String[] args) {
//        new CrawlData();
        History history = new Process().getHistory();
//        history.write();
    }
}