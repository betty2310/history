package com.hust.process;

import com.hust.historical.History;
import com.hust.historical.model.*;
import com.hust.utils.FormatString;
import com.hust.utils.MyDate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.List;

public class Process {
    private History history;

    public Process() {
        history = new History();
        processDynasty();
        processMonarch();
        processFigure();
        processFestival();
        processEvent();
        processSite();
    }

    public History getHistory() {
        return history;
    }

    public void processDynasty() {
        JSONArray array = jsonArray("/data/Dynasty.json");
        for (int i = 0; i < array.length(); ++i) {
            JSONObject obj = array.getJSONObject(i);
            String name = obj.getString("ten");
            String countryName = obj.getString("ten_quoc_gia");
            String language = obj.getString("ngon_ngu");
            String capital = obj.getString("thu_do");
            String religion = obj.getString("ton_giao");
            String position = obj.getString("vi_the");
            String unit = obj.getString("don_vi_tien");
            String time = obj.getString("time");
            MyDate start = FormatString.getBeginDate(time);
            MyDate end = FormatString.getEndDate(time);
            Dynasty dynasty = new Dynasty(name, countryName, start, end, capital, language, religion, position, unit);
            if (!history.getDynasties().add(dynasty)) {
                System.out.println("Failed to add " + name);
            }
        }
    }

    public void processMonarch() {
        JSONArray array = jsonArray("/data/Monarch.json");
        for (int i = 0; i < array.length(); ++i) {
            JSONObject obj = array.getJSONObject(i);
            String name = FormatString.removeBracket(obj.getString("ten"));
            String eraName = obj.getString("trieu_dai");
            MyDate birth = FormatString.getDateInlineFromString(obj.getString("sinh"));
            String birthPlace = FormatString.getBirthPlaceFromString(obj.getString("sinh"));
            MyDate death = FormatString.getDateInlineFromString(obj.getString("mat"));
            String deathPlace = FormatString.getBirthPlaceFromString(obj.getString("mat"));
            MyDate reignStart = FormatString.getDateInlineFromString(FormatString.removeBracket(obj.getString("tri_vi_bat_dau")));
            MyDate reignEnd = FormatString.getDateInlineFromString(FormatString.removeBracket(obj.getString("tri_vi_ket_thuc")));
            String nienHieu = FormatString.removeBracket(obj.getString("nien_hieu"));
            String mieuHieu = FormatString.removeBracket(obj.getString("mieu_hieu"));
            String tenHuy = FormatString.removeBracket(obj.getString("huy"));
            String theThu = FormatString.removeBracket(obj.getString("the_thu"));
            String predecessor = FormatString.removeBracket(obj.getString("tien_nhiem"));
            String successor = FormatString.removeBracket(obj.getString("ke_nhiem"));
            Monarch monarch = new Monarch(name, birth, death, birthPlace, deathPlace, reignStart, reignEnd, nienHieu, mieuHieu, tenHuy, theThu, predecessor, successor,eraName);
            if (history.findDynasty(eraName) != null) {
                history.findDynasty(eraName).addHuman(monarch);
            }
        }
    }

    public void processFigure() {
        JSONArray array = jsonArray("/data/HistoricalFigure.json");
        for (int i = 0; i < array.length(); ++i) {
            JSONObject obj = array.getJSONObject(i);
            String name = FormatString.removeBracket(obj.getString("ten"));
            MyDate birth = new MyDate();
            MyDate death = new MyDate();
            String birthPlace = "";
            String deathPlace = "";
            if (obj.has("sinh") && obj.has("mat")) {
                birth = FormatString.getDateInlineFromString(obj.getString("sinh"));
                birthPlace = FormatString.getBirthPlaceFromString(FormatString.removeBracket(obj.getString("sinh")));
                death = FormatString.getDateInlineFromString(obj.getString("mat"));
                deathPlace = FormatString.getBirthPlaceFromString(FormatString.removeBracket(obj.getString("mat")));
            }
            String url = obj.getString("url");
            Figure figure = new Figure(name, birth, death, birthPlace, deathPlace, url, "");

            if (history.findDynasty(figure.getDynasty()) != null) {
                String eraName = history.findDynasty(figure.getDynasty()).getName();
                figure = new Figure(name, birth, death, birthPlace, deathPlace, url, eraName);
                history.findDynasty(figure.getDynasty()).addHuman(figure);
            }
        }
    }

    public void processFestival() {
        JSONArray array = jsonArray("/data/Festival.json");
        for (int i = 0; i < array.length(); ++i) {
            JSONObject obj = array.getJSONObject(i);
            String name = "";
            String firstTime = "";
            String note = "";
            String position = "";
            String nvlq = "";
            String dateStart = "";
            if (obj.has("ten")) {
                name = FormatString.removeBracket(obj.getString("ten"));
            }
            if (obj.has("lan_dau_to_chuc")) {
                firstTime = obj.getString("lan_dau_to_chuc");
            }
            if (obj.has("ghi_chu")) {
                note = obj.getString("ghi_chu");
            }
            if (obj.has("vi_tri")) {
                position = obj.getString("vi_tri");
            }
            Human human = null;
            if (obj.has("nhan_vat_lien_quan")) {
                nvlq = obj.getString("nhan_vat_lien_quan");
                human = history.findHuman(nvlq);
            }
            if (obj.has("ngay_bat_dau")) {
                dateStart = obj.getString("ngay_bat_dau");
            }
            if (!name.equals("")) {
                Festival festival = new Festival(name, note, firstTime, position, human, dateStart);
                history.getFestivals().add(festival);
            }
        }
    }

    public void processEvent() {
        JSONArray array = jsonArray("/data/HistoricalEvent.json");
        for (int i = 0; i < array.length(); ++i) {
            JSONObject obj = array.getJSONObject(i);
            String name = "";
            Dynasty era = null;
            MyDate start = new MyDate();
            MyDate end = new MyDate();
            if (obj.has("noi dung")) {
                String content = FormatString.removeBracket(obj.getString("noi dung"));
                String time = FormatString.getEventTime(content);
                if (time.contains("-") || time.contains("TCN")) {
                    start = FormatString.getBeginDate(time);
                    end = FormatString.getEndDate(time);
                } else {
                    if (!time.equals(""))
                        start = new MyDate(Integer.parseInt(time));
                }
                name = FormatString.getEventContent(content);
                if (name.equals("")) continue;
            }

            String eraName = "";
            if (obj.has("thoi_ki")) {
                eraName = FormatString.removeBracket(obj.getString("thoi_ki"));
            }
            Event event = new Event(name, start, end);
            List<String> nouns = FormatString.getNouns(name);
            for (String noun : nouns) {
                if (noun.contains(" ")) {
                    Human human = history.findHuman(noun);
                    if (human != null) event.addHuman(human);
                }
            }
            if (history.findDynasty(eraName) != null) {
                history.findDynasty(eraName).addEvent(event);
            }
        }
    }

    public void processSite() {
        JSONArray array = jsonArray("/data/HistoricalSite.json");
        for (int i = 0; i < array.length(); ++i) {
            JSONObject obj = array.getJSONObject(i);
            String name = "";
            String position = "";
            String note = "";
            String type = "";
            if (!obj.has("ten")) {
                continue;
            }
            if (obj.has("loai")) {
                type = obj.getString("loai");
                if (!type.contains("Lịch sử")) continue;
            }

            name = obj.getString("ten");
            position = obj.getString("vi_tri");
            if (obj.has("ghi_chu")) {
                note = FormatString.removeBracket(obj.getString("ghi_chu"));
            }
            String date = "";
            MyDate myDate = new MyDate();
            if (obj.has("nam_cong_nhan")) {
                date = obj.getString("nam_cong_nhan");
                if (date.equals("") || date.equals("xx")) continue;
                myDate = new MyDate(date);
            }
            Site site = new Site(name, myDate, position, note);
            List<String> nouns = FormatString.getNouns(name);
            for (String noun : nouns) {
                if (noun.contains(" ")) {
                    Human human = history.findHuman(noun);
                    if (human != null) site.setRelatedHuman(human.getName());
                }
            }
            history.getSites().add(site);
        }
    }

    public JSONArray jsonArray(String resource) {
        InputStream is = getClass().getResourceAsStream(resource);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resource);
        }
        JSONTokener token = new JSONTokener(is);
        return new JSONArray(token);
    }
}
