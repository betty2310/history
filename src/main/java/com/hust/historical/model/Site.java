package com.hust.historical.model;

import com.hust.utils.MyDate;

public class Site extends HistoricalObject {
    private String position;

    public Site(String name, MyDate birth, String position) {
        super(name, birth);
        this.position = position;
    }

    @Override
    public void setToTimeLine() {

    }
}
