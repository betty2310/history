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
    private Monarch predecessor;
    private Monarch successor;

    public Monarch(String name, MyDate birth, String birthPlace, String deathPlace, Dynasty dynasty) {
        super(name, birth, birthPlace, deathPlace, dynasty);
    }

    public void setToTimeLine() {
    }

    @Override
    public void setDynasty() {

    }
}
