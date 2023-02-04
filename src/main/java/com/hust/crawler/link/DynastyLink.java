package com.hust.crawler.link;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class DynastyLink extends AbstractLink {
    private ArrayList<String> urlList = new ArrayList<String>();

    public DynastyLink(String url) {
        super(url);
    }

    @Override
    protected void setProperties() {
        properties = new String[]{"ten", "ten_quoc_gia", "time", "vi_the", "thu_do", "ngon_ngu", "ton_giao", "don_vi_tien"};
    }

    @Override
    public void crawl(String url) {
        initLinks();
        for (String link : urlList) {
            Document doc = null;
            try {
                doc = Jsoup.connect(link).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Element title = doc.select("span.mw-page-title-main").first();
            String ten = title.text();
            Element table = doc.select("table.infobox").first();
            String tenQuocGia = table.getElementsByTag("span").first().text();
            Elements times = table.select("td[colspan='2']");
            String time = times.get(1).text();
            String viThe = table.select("th[scope='row']:matchesOwn(Vị thế)").next().text();
            String thuDo = "";
            Element eThuDo = table.select("a[href*='Th%E1%BB%A7_%C4%91%C3%B4']").first();
            if (eThuDo != null) {
                thuDo = eThuDo.parent().nextElementSibling().text();
            }
            String ngonNgu = table.select("th[scope='row']:matchesOwn(Ngôn ngữ thông dụng)").next().text();
            String tonGiao = "";
            Element eTonGiao = table.select("a[href*='T%C3%B4n_gi%C3%A1o']").first();
            if (eTonGiao != null) {
                tonGiao = eTonGiao.parent().nextElementSibling().text();
            }
            String donViTien = "";
            Element eDonViTien = table.select("a[href*='%C4%90%C6%A1n_v%E1%BB%8B_ti%E1%BB%81n_t%E1%BB%87']").first();
            if (eDonViTien != null) {
                donViTien = eDonViTien.parent().nextElementSibling().text();
            }
            ArrayList<String> data = new ArrayList<String>();
            data.add(ten);
            data.add(tenQuocGia);
            data.add(time);
            data.add(viThe);
            data.add(thuDo);
            data.add(ngonNgu);
            data.add(tonGiao);
            data.add(donViTien);
            getData().add(data);
        }
    }

    private void initLinks() {
        urlList.add("https://vi.wikipedia.org/wiki/Th%E1%BB%9Di_k%E1%BB%B3_B%E1%BA%AFc_thu%E1%BB%99c_l%E1%BA%A7n_th%E1%BB%A9_nh%E1%BA%A5t");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_Tri%E1%BB%87u");
        urlList.add("https://vi.wikipedia.org/wiki/Th%E1%BB%9Di_k%E1%BB%B3_B%E1%BA%AFc_thu%E1%BB%99c_l%E1%BA%A7n_th%E1%BB%A9_hai");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_Ti%E1%BB%81n_L%C3%BD");
        urlList.add("https://vi.wikipedia.org/wiki/Th%E1%BB%9Di_k%E1%BB%B3_B%E1%BA%AFc_thu%E1%BB%99c_l%E1%BA%A7n_th%E1%BB%A9_ba");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_Ng%C3%B4");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_%C4%90inh");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_Ti%E1%BB%81n_L%C3%AA");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_L%C3%BD");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_Tr%E1%BA%A7n");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_H%E1%BB%93");
        urlList.add("https://vi.wikipedia.org/wiki/Th%E1%BB%9Di_k%E1%BB%B3_B%E1%BA%AFc_thu%E1%BB%99c_l%E1%BA%A7n_th%E1%BB%A9_t%C6%B0");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_H%E1%BA%ADu_Tr%E1%BA%A7n");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_L%C3%AA_s%C6%A1");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_M%E1%BA%A1c");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_T%C3%A2y_S%C6%A1n");
        urlList.add("https://vi.wikipedia.org/wiki/Nh%C3%A0_Nguy%E1%BB%85n");
    }
}
