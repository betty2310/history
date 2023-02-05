package com.hust.historical.model;

import com.hust.utils.MyDate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dynasty extends HistoricalObject {
    private MyDate end;
    private String countryName;
    private String capital;
    private String language;
    private String religion;
    private String position;
    private String unit;
    private ArrayList<Human> humanArrayList;
    private ArrayList<Event> events;

    public Dynasty(String name, String countryName, MyDate start, MyDate end, String capital, String language, String religion, String position, String unit) {
        super(name, start);
        this.end = end;
        this.countryName = countryName;
        this.capital = capital;
        this.language = language;
        this.religion = religion;
        this.position = position;
        this.unit = unit;
        humanArrayList = new ArrayList<Human>();
        events = new ArrayList<Event>();
    }

    public ArrayList<Human> getHumanArrayList() {
        return humanArrayList;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public boolean addEvent(Event event) {
        if (events.contains(event))
            return false;
        events.add(event);
        return true;
    }

    public boolean removeEven(Event event) {
        return events.remove(event);
    }

    public Event findEven(String name) {
        for(Event e : events) {
            if (e.getName().equals(name))
                return e;
        }
        return null;
    }
    public boolean addHuman(Human human) {
        if (humanArrayList.contains(human))
            return false;
        humanArrayList.add(human);
        return true;
    }

    public boolean removeHuman(Human human) {
        return humanArrayList.remove(human);
    }

    public Human findHuman(String name) {
        for(Human human : humanArrayList) {
            if (human.getName().equals(name))
                return human;
        }
        return null;
    }
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("triều đại", super.getName());
        jsonObject.put("bắt đầu", super.getBirth().toString());
        jsonObject.put("kết thúc", end.toString());
        jsonObject.put("quốc gia", countryName);
        jsonObject.put("thủ đô", capital);
        jsonObject.put("ngôn ngữ", language);
        jsonObject.put("tôn giáo", religion);
        jsonObject.put("vị thế", position);
        jsonObject.put("dơn vị tiền tệ", unit);
        StringBuilder relatedHumans = new StringBuilder();
        for (Human human : humanArrayList) {
            relatedHumans.append(human.getName()).append(", ");
        }
        jsonObject.put("nhân vật liên quan", relatedHumans);
        StringBuilder relatedEvents = new StringBuilder();
        for (Event event : events) {
            relatedEvents.append(event.getName()).append(", ");
        }
        jsonObject.put("sự kiện liên quan", relatedEvents);
        return jsonObject;
    }
    @Override
    public void setToTimeLine() {

    }
}
