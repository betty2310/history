package com.hust.historical.model;

import com.hust.utils.MyDate;
import de.vandermeer.asciitable.AsciiTable;
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
    public String getStrHuman() {
        StringBuilder str = new StringBuilder();
        for (Human human : humanArrayList) {
            str.append(human.getName()).append(", ");
        }
        return str.toString();
    }
    public String getStrEvent() {
        StringBuilder str = new StringBuilder();
        for (Event event : events) {
            str.append(event.getName()).append(", ");
        }
        return str.toString();
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

    @Override
    public String toString() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Tri???u ?????i", "B???t ?????u", "K???t th??c", "Qu???c gia", "Th??? ????", "Ng??n ng???", "T??n gi??o", "V??? th???", "????n v??? ti???n t???", "Nh??n v???t li??n quan", "S??? ki???n li??n quan");
        at.addRule();
        at.addRow(super.getName(), super.getBirth().toString(), end.toString(), countryName, capital, language, religion, position, unit, getStrHuman(), getStrEvent());
        at.addRule();
        at.getContext().setWidth(150);
        return at.render();

    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tri???u ?????i", super.getName());
        jsonObject.put("b???t ?????u", super.getBirth().toString());
        jsonObject.put("k???t th??c", end.toString());
        jsonObject.put("qu???c gia", countryName);
        jsonObject.put("th??? ????", capital);
        jsonObject.put("ng??n ng???", language);
        jsonObject.put("t??n gi??o", religion);
        jsonObject.put("v??? th???", position);
        jsonObject.put("d??n v??? ti???n t???", unit);
        StringBuilder relatedHumans = new StringBuilder();
        for (Human human : humanArrayList) {
            relatedHumans.append(human.getName()).append(", ");
        }
        jsonObject.put("nh??n v???t li??n quan", relatedHumans);
        StringBuilder relatedEvents = new StringBuilder();
        for (Event event : events) {
            relatedEvents.append(event.getName()).append(", ");
        }
        jsonObject.put("s??? ki???n li??n quan", relatedEvents);
        return jsonObject;
    }
    @Override
    public void setToTimeLine() {

    }
}
