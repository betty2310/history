package com.hust.crawler.link;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class SiteLink extends AbstractLink {
    public SiteLink(String url) {
        super(url);
    }

    @Override
    protected void setProperties() {
        properties = new String[]{"ten", "vi_tri", "loai", "nam_cong_nhan", "ghi_chu", ""};
    }

    @Override
    public void crawl(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements tables = doc.select("table.wikitable");
        for (Element table : tables) {
            Elements rows = table.select("tr");
            Elements numCols = table.select("th");
            if (numCols.size() == 5) {
                for (Element row : rows) {
                    Elements columns = row.select("td");
                    ArrayList<String> data = new ArrayList<>();
                    for (Element column : columns) {
                        data.add(column.text());
                    }
                    getData().add(data);
                }
            } else {
                for (Element row : rows) {
                    Elements columns = row.select("td");
                    ArrayList<String> data = new ArrayList<>();
                    if (columns.size() > 0) {
                        data.add(columns.get(1).text());
                        data.add(columns.get(2).text());
                        data.add("Lịch sử");
                        data.add("-1");
                        data.add(columns.get(3).text());
                        getData().add(data);
                    }
                }
            }
        }
    }
}
