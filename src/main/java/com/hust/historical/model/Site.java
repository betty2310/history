package com.hust.historical.model;

import com.hust.utils.MyDate;

public class Site extends HistoricalObject {
    private String position;
    private String note;

    public Site(String name, MyDate birth, String position, String note) {
        super(name, birth);
        this.position = position;
        this.note = note;
    }

    @Override
    public void setToTimeLine() {

    }
}
