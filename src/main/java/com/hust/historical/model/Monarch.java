package com.hust.historical.model;

import com.hust.utils.MyDate;

public class Monarch extends Human {
    private MyDate reignStart;
    private MyDate reignEnd;
    private String eraName;
    private String nienHieu;
    private String mieuHieu;
    private String tenHuy;
    private String theThu;
    private String predecessor;
    private String successor;

    public Monarch(String name, MyDate birth,MyDate death,  String birthPlace, String deathPlace, MyDate reignStart, MyDate reignEnd, String nienHieu, String mieuHieu, String tenHuy, String theThu, String predecessor, String successor) {
        super(name, birth,death, birthPlace, deathPlace);
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
        this.nienHieu = nienHieu;
        this.mieuHieu = mieuHieu;
        this.tenHuy = tenHuy;
        this.theThu = theThu;
        this.predecessor = predecessor;
        this.successor = successor;
    }

    public void setToTimeLine() {
    }

    @Override
    public String getDynasty() {
        return "";
    }
}
