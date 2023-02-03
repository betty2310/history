package com.hust.crawler.link;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MonarchLink extends AbstractLink {
    public MonarchLink(String url) {
        super(url);
    }

    @Override
    public void setProperties() {
        properties = new String[]{"ten", "mieu_hieu", "ton_hieu", "nien_hieu", "huy", "the_thu", "tri_vi_bat_dau", "tri_vi_ket_thuc", "tien_nhiem", "ke_nhiem", "sinh", "mat", "an_tang", "trieu_dai"};
    }

    @Override
    public void crawl(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements tables = doc.select("table[cellpadding='0']");
        for (Element table : tables) {
            Elements rows = table.select("tr");
            for (Element row : rows) {
                Elements columns = row.select("td");
                if (columns.size() != 10) continue;
                ArrayList<String> data = new ArrayList<>();
                for (Element column : columns) {
                    data.add(column.text());
                }
                data.remove(0);
                data.remove(7);
                Element link = columns.get(1).select("a").first();
                Document monarchDoc = null;
                try {
                    monarchDoc = Jsoup.connect(link.attr("abs:href")).get();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String tienNhiem = monarchDoc.select("th[scope='row']:matchesOwn(Tiền nhiệm)").next().text();
                String keNhiem = monarchDoc.select("th[scope='row']:matchesOwn(Kế nhiệm)").next().text();
                String sinh = monarchDoc.select("th[scope='row']:matchesOwn(Sinh)").next().text();
                String mat = monarchDoc.select("th[scope='row']:matchesOwn(Mất)").next().text();
                String anTang = monarchDoc.select("th[scope='row']:matchesOwn(An táng)").next().text();
                String trieuDai = monarchDoc.select("th[scope='row']:matchesOwn(Triều đại)").next().text();
                data.add(tienNhiem);
                data.add(keNhiem);
                data.add(sinh);
                data.add(mat);
                data.add(anTang);
                data.add(trieuDai);
                getData().add(data);
            }
        }
    }
}
