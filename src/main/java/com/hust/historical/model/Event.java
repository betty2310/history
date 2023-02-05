package com.hust.historical.model;

import com.hust.utils.MyDate;
import org.json.JSONObject;

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
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sự kiện", super.getName());
        jsonObject.put("bắt đầu", super.getBirth().toString());
        jsonObject.put("kết thúc", eventEnd.toString());
        StringBuilder relatedHumansString = new StringBuilder();
        for (Human human : relatedHuman) {
            relatedHumansString.append(human.getName()).append(", ");
        }
        // remove last 2 characters in string
        if(relatedHumansString.length() > 2)
            relatedHumansString.delete(relatedHumansString.length() - 2, relatedHumansString.length());
        jsonObject.put("nhân vật liên quan", relatedHumansString.toString());
        return jsonObject;
    }

    @Override
    public void setToTimeLine() {

    }
}
