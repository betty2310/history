package com.hust.crawl.link;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DynastyLink extends AbstractLink {
    public DynastyLink(String url) {
        super(url);
    }

    @Override
    protected void setProperties() {

    }
    @Override
    public void crawl(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements titles = doc.select("h3");
        for (Element title : titles) {
            System.out.println(title.text());
        }
    }
}
