package com.hust.historical.model;

public class Festival extends HistoricalObject {
    private String position;
    private String note;
    private String firsTime;

    public Festival(String name) {
        super(name);
    }

    @Override
    public void setToTimeLine() {

    }
}
