package com.hust.crawler.link;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class EventLink extends AbstractLink {
    public EventLink(String url) {
        super(url);
    }

    @Override
    protected void setProperties() {
        properties = new String[]{"thoi_ki", "noi dung"};
    }
    @Override
    public void crawl(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements h3s = doc.getElementsByTag("h3");
        for (int i = 0; i < h3s.size(); ++i) {
            int j = i + 1;
            if (j >= h3s.size()) {
                break;
            }
            Element startH3 = h3s.get(i);
            Element endH3 = h3s.get(j);

            Element current = startH3;
            while (current != endH3) {
                ArrayList<String> data = new ArrayList<>();
                current = current.nextElementSibling();
                if (current.tagName().equals("p")) {
                    data.add(h3s.get(i).text().replaceAll("\\[.*?\\]", ""));
                    data.add(current.text());
                }
                getData().add(data);
            }
        }
    }
}
