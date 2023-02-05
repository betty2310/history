package com.hust.historical.model;

import com.hust.utils.MyDate;
import org.json.JSONObject;

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
    public  String getName() {
        return name;
    }

    public MyDate getBirth() {
        return birth;
    }
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tên", name);
        jsonObject.put("bắt đầu", birth.toString());
        return jsonObject;
    }

    public abstract void setToTimeLine();
}
