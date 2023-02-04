package com.hust.crawler;

import com.hust.crawler.link.*;

public class CrawlData {
    public CrawlData() {
        Link link = new DynastyLink("https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam#%C4%90%E1%BB%8Dc_th%C3%AAm");
        link.writeToFile("Dynasty.json");
        link = new FigureLink("https://nguoikesu.com/nhan-vat");
        link.writeToFile("HistoricalFigure.json");
        link = new SiteLink("https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_Di_t%C3%ADch_qu%E1%BB%91c_gia_Vi%E1%BB%87t_Nam");
        link.writeToFile("HistoricalSite.json");
        link = new FestivalLink("https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam");
        link.writeToFile("Festival.json");
        link = new EventLink("https://vi.wikipedia.org/wiki/Ni%C3%AAn_bi%E1%BB%83u_l%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam");
        link.writeToFile("HistoricalEvent.json");
        link = new MonarchLink("https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam#%C4%90%E1%BB%8Dc_th%C3%AAm");
        link.writeToFile("Monarch.json");
    }
}
