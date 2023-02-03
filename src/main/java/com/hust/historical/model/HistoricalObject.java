package com.hust.historical.model;

import com.hust.utils.MyDate;

public abstract class HistoricalObject {
    private String name;
    private MyDate birth;
    public HistoricalObject(String name) {
        this.name = name;
    }
    public HistoricalObject(String name, MyDate birth) {
        this.name = name;
        this.birth = birth;
    }
    public abstract void setToTimeLine();
}
