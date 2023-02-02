package com.hust.crawl.link;

public interface Link {
    void writeToFile(String fileName);
    void crawl(String url);
}
