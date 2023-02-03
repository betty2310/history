package com.hust.historical.model;

import com.hust.utils.MyDate;

public class Event extends HistoricalObject{
    private MyDate eventEnd;

    public Event(String name, MyDate eventStart, MyDate eventEnd) {
        super(name, eventStart);
        this.eventEnd = eventEnd;
    }

    @Override
    public void setToTimeLine() {

    }
}
