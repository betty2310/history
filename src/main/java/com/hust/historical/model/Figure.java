package com.hust.historical.model;

import com.hust.utils.MyDate;

public class Figure extends Human {
    private String url;
    public Figure(String name, MyDate birth,  String birthPlace, String deathPlace, Dynasty dynasty, String url) {
        super(name, birth, birthPlace, deathPlace, dynasty);
        this.url = url;
    }
    @Override
    public void setToTimeLine() {

    }

    @Override
    public void setDynasty() {

    }
}
