package com.hust.historical.model;

import com.hust.utils.MyDate;

import java.util.ArrayList;

public class Dynasty extends HistoricalObject {
    private MyDate end;
    private String capital;
    private String language;
    private String religion;
    private String position;
    private ArrayList<Human> humanArrayList;

    public Dynasty(String name, MyDate start, MyDate end, String capital, String language, String religion, String position) {
        super(name, start);
        this.end = end;
        this.capital = capital;
        this.language = language;
        this.religion = religion;
        this.position = position;
        humanArrayList = new ArrayList<Human>();
    }

    public boolean addHuman(Human human) {
        if(humanArrayList.contains(human))
            return false;
        humanArrayList.add(human);
        return true;
    }
    public boolean removeHuman(Human human) {
        return humanArrayList.remove(human);
    }

    @Override
    public void setToTimeLine() {

    }
}
