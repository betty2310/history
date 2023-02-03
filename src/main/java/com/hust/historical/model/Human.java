package com.hust.historical.model;

import com.hust.utils.MyDate;

public abstract class Human extends HistoricalObject {
    private String birthPlace;
    private String deathPlace;
    private Dynasty dynasty;
    public Human(String name, MyDate birth, String birthPlace, String deathPlace, Dynasty dynasty) {
        super(name, birth);
        this.birthPlace = birthPlace;
        this.deathPlace = deathPlace;
        this.dynasty = dynasty;
    }
    public abstract void setDynasty();
}
