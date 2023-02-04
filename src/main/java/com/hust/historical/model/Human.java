package com.hust.historical.model;

import com.hust.utils.MyDate;

public abstract class Human extends HistoricalObject {
    private MyDate death;
    private String birthPlace;
    private String deathPlace;
    private Dynasty dynasty;

    public Human(String name, MyDate birth, MyDate death, String birthPlace, String deathPlace) {
        super(name, birth);
        this.death = death;
        this.birthPlace = birthPlace;
        this.deathPlace = deathPlace;
    }

    @Override
    public MyDate getBirth() {
        return super.getBirth();
    }

    public abstract String getDynasty();
}
