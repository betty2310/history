package com.hust.historical.model;

import org.json.JSONObject;

public class Festival extends HistoricalObject {
    private String position;
    private String note;
    private String firsTime;
    private Human human;
    private String dateStart;

    public Festival(String name) {
        super(name);
    }
    public Festival(String name, String note, String firsTime, String position, Human human, String dateStart) {
        super(name);
        this.position = position;
        this.note = note;
        this.firsTime = firsTime;
        this.human = human;
        this.dateStart = dateStart;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tên", super.getName());
        jsonObject.put("ghi chú", note);
        jsonObject.put("vị trí", position);
        jsonObject.put("lần đầu tổ chức", firsTime);
        jsonObject.put("ngày bắt đầu", dateStart);
        jsonObject.put("nhân vật liên quan", human == null ? "" : human.getName());
        return jsonObject;
    }

    @Override
    public void setToTimeLine() {

    }
}
