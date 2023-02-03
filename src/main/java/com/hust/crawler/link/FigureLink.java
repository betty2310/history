package com.hust.crawler.link;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FigureLink extends AbstractLink {
    private HashSet<String> links;

    public FigureLink(String url) {
        super(url);
        links = new HashSet<String>();
    }

    @Override
    protected void setProperties() {
        properties = new String[]{"ten", "sinh", "mat", "url"};
    }

    @Override
    public void crawl(String url) {
        if (!links.contains(url)) {
            links.add(url);
            try {
                Document document = Jsoup.connect(url).get();
                Elements articleLinks = document.select("h2 a[href^='/nhan-vat/']");
                for (Element article : articleLinks) {
                    Document articleDoc = Jsoup.connect(article.attr("abs:href")).get();
                    Elements infobox = articleDoc.select("table.infobox");
                    String infoBirth = "";
                    String infoDeath = "";

                    if (!infobox.isEmpty()) {
                        infoBirth = articleDoc.select("th[scope='row']:matchesOwn(Sinh)").next().text();
                        infoDeath = articleDoc.select("th[scope='row']:matchesOwn(Mất)").next().text();
                    } else {
                        Element paragraph = articleDoc.select("p").first();
                        String[] years = new String[2];
                        Pattern pattern = Pattern.compile("(\\d{3,4}|\\?)");
                        Matcher matcher = pattern.matcher(paragraph.text());
                        int i = 0;
                        while (matcher.find() && i < 2) {
                            String year = matcher.group();
                            if (year.equals("?")) {
                                years[i] = "?";
                            } else {
                                years[i] = year;
                            }
                            i++;
                        }
                        infoBirth = years[0];
                        infoDeath = years[1];
                    }
                    String finalInfoBirth = infoBirth;
                    String finalInfoDeath = infoDeath;
                    getData().add(new ArrayList<String>() {{
                        add(article.text());
                        add(finalInfoBirth);
                        add(finalInfoDeath);
                        add(article.attr("abs:href"));
                    }});
                }
                Elements linksOnPage = document.select("a[href^='/nhan-vat?start=']");
                for (Element page : linksOnPage) {
                    crawl(page.attr("abs:href"));
                }
            } catch (IOException e) {
                System.err.print("For '" + url + "': " + e.getMessage());
            }
        }
    }
}
