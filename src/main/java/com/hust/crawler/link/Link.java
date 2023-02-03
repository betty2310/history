package com.hust.crawler.link;

public interface Link {
    void writeToFile(String fileName);
    void crawl(String url);
}
