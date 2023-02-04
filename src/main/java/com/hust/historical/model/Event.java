package com.hust.historical.model;

import com.hust.utils.MyDate;

import java.util.ArrayList;
import java.util.List;

public class Event extends HistoricalObject{
    private MyDate eventEnd;
    private List<Human> relatedHuman;

    public Event(String name, MyDate eventStart, MyDate eventEnd) {
        super(name, eventStart);
        this.eventEnd = eventEnd;
        relatedHuman = new ArrayList<Human>();
    }

    public boolean addHuman(Human human) {
        if (relatedHuman.contains(human))
            return false;
        relatedHuman.add(human);
        return true;
    }

    public boolean removeHuman(Human human) {
        return relatedHuman.remove(human);
    }

    public Human findHuman(String name) {
        for(Human human : relatedHuman) {
            if (human.getName().equals(name))
                return human;
        }
        return null;
    }

    @Override
    public void setToTimeLine() {

    }
}
