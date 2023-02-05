package com.hust.historical.model;

import com.hust.utils.MyDate;
import de.vandermeer.asciitable.AsciiTable;
import org.json.JSONObject;

public class Monarch extends Human {
    private MyDate reignStart;
    private MyDate reignEnd;
    private String nienHieu;
    private String mieuHieu;
    private String tenHuy;
    private String theThu;
    private String predecessor;
    private String successor;

    public Monarch(String name, MyDate birth, MyDate death, String birthPlace, String deathPlace, MyDate reignStart, MyDate reignEnd, String nienHieu, String mieuHieu, String tenHuy, String theThu, String predecessor, String successor, String eraName) {
        super(name, birth, death, birthPlace, deathPlace, eraName);
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
        this.nienHieu = nienHieu;
        this.mieuHieu = mieuHieu;
        this.tenHuy = tenHuy;
        this.theThu = theThu;
        this.predecessor = predecessor;
        this.successor = successor;
    }
    @Override
    public String toString() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("tên", "sinh", "mất", "trị vì bắt đầu", "trị vì kết thúc", "niên hiệu", "miếu hiệu", "tên huý", "thế thứ", "tiền nhiệm", "kế nhiệm", "triều đại");
        at.addRule();
        at.addRow(super.getName(), super.getBirth().toString(),super.getDeath().toString(), reignStart.toString(), reignEnd.toString(), nienHieu, mieuHieu, tenHuy, theThu, predecessor, successor, super.getDynastyName());
        at.addRule();
        at.getContext().setWidth(150);
        return at.render();
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put("trị vì bắt đầu", reignStart.toString());
        jsonObject.put("trị vì kết thúc", reignEnd.toString());
        jsonObject.put("niên hiệu", nienHieu);
        jsonObject.put("miếu hiệu", mieuHieu);
        jsonObject.put("tên huý", tenHuy);
        jsonObject.put("thế thứ", theThu);
        jsonObject.put("tiền nhiệm", predecessor);
        jsonObject.put("kế nhiệm", successor);
        return jsonObject;
    }

    public void setToTimeLine() {
    }

    @Override
    public String getDynasty() {
        return "";
    }
}
