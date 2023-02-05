package com.hust.historical.model;

import com.hust.utils.MyDate;
import de.vandermeer.asciitable.AsciiTable;
import org.json.JSONObject;

public class Figure extends Human {
    private String url;
    public Figure(String name, MyDate birth, MyDate death, String birthPlace, String deathPlace, String url, String era) {
        super(name, birth, death, birthPlace, deathPlace, era);
        this.url = url;
    }

    @Override
    public String toString() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("tên", "sinh", "mất", "nơi sinh", "nơi mất", "url", "triều đại");
        at.addRule();
        at.addRow(super.getName(), super.getBirth().toString(),super.getDeath().toString(), super.getBirthPlace(), super.getDeathPlace(), url, super.getDynastyName());
        at.addRule();
        at.getContext().setWidth(150);
        return at.render();
    }

    @Override
    public void setToTimeLine() {

    }
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put("url", url);
        return jsonObject;
    }

    @Override
    public String getDynasty() {
        int birth = super.getBirth().getYear();
        if(birth >= -111 && birth <=40) return "Thời kỳ Bắc thuộc lần thứ nhất";
        if(birth >= -204 && birth <=-111) return "Nhà Triệu";
        if(birth >= 43 && birth <= 544) return "Thời kỳ Bắc thuộc lần thứ hai";
        if(birth >= 544 && birth <= 602) return "Nhà Tiền Lý";
        if(birth >= 603  && birth <= 939) return "Thời kỳ Bắc thuộc lần thứ ba";
        if(birth >= 939  && birth <= 965) return "Nhà Ngô";
        if(birth >= 968  && birth <= 980) return "Nhà Đinh";
        if(birth >= 980  && birth <= 1009) return "Nhà Tiền Lê";
        if(birth >= 1009 && birth <=  1225) return "Nhà Lý";
        if(birth >= 1226 && birth <=  1400) return "Nhà Trần";
        if(birth >= 1400 && birth <=  1407) return "Nhà Hồ";
//        if(birth >= -1 && birth <= 1) return "Thời kỳ Bắc thuộc lần thứ tư";
        if(birth >= 1407 && birth <=  1414) return "Nhà Hậu Trần";
        if(birth >= 1428 && birth <=  1527) return "Nhà Lê sơ";
        if(birth >= 1527 && birth <=  1677) return "Nhà Mạc";
//        if(birth >= -1 && birth <= 1) return "Nhà Tây Sơn";
        if(birth >= 1802 && birth <=  1945) return "Nhà Nguyễn";
        return "";
    }
}
