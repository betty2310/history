package com.hust.crawl.link;

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
        properties = new String[]{"ten", "vi_tri", "loai", "nam_cong_nhan", "ghi_chu"};
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
            for (Element row : rows) {
                Elements columns = row.select("td");
                ArrayList<String> data = new ArrayList<>();
                for (Element column : columns) {
                    if (column.text().isEmpty()) {
                        data.add("");
                    } else {
                        data.add(column.text());
                    }
                }
                getData().add(data);
            }
        }
    }
}
