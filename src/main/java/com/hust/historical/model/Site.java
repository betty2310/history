package com.hust.historical.model;

import com.hust.utils.MyDate;
import org.json.JSONObject;

public class Site extends HistoricalObject {
    private String position;
    private String note;
    private String relatedHuman;

    public Site(String name, MyDate birth, String position, String note) {
        super(name, birth);
        this.position = position;
        this.note = note;
    }

    public void setRelatedHuman(String relatedHuman) {
        this.relatedHuman = relatedHuman;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("di tích", super.getName());
        jsonObject.put("năm CN", super.getBirth().toString());
        jsonObject.put("vị trí", position);
        jsonObject.put("ghi chú", note);
        jsonObject.put("nhân vật liên quan", relatedHuman == null ? "" : relatedHuman);
        return jsonObject;
    }

    @Override
    public void setToTimeLine() {

    }
}
