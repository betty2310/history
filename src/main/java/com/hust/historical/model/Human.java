package com.hust.historical.model;

import com.hust.utils.MyDate;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class Human extends HistoricalObject {
    private MyDate death;
    private String birthPlace;
    private String deathPlace;
    private String dynasty;

    public Human(String name, MyDate birth, MyDate death, String birthPlace, String deathPlace, String dynasty) {
        super(name, birth);
        this.death = death;
        this.birthPlace = birthPlace;
        this.deathPlace = deathPlace;
        this.dynasty = dynasty;
    }

    @Override
    public MyDate getBirth() {
        return super.getBirth();
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tên", super.getName());
        jsonObject.put("sinh", super.getBirth().toString());
        jsonObject.put("mất", death.toString());
        jsonObject.put("nơi sinh", birthPlace);
        jsonObject.put("triều đại", dynasty);
        jsonObject.put("nơi mất", deathPlace);
        return jsonObject;
    }
    public abstract String getDynasty();
}
