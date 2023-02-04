package com.hust.historical.model;

public class Festival extends HistoricalObject {
    private String position;
    private String note;
    private String firsTime;
    private Human human;
    private String dateStart;

    public Festival(String name) {
        super(name);
    }
    public Festival(String name, String note, String firsTime, String position, Human human, String dateStart) {
        super(name);
        this.position = position;
        this.note = note;
        this.firsTime = firsTime;
        this.human = human;
        this.dateStart = dateStart;

    }

    @Override
    public void setToTimeLine() {

    }
}
