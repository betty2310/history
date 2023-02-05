package com.hust.historical;

import com.hust.historical.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class History {
    private ArrayList<Dynasty> dynasties;
    private ArrayList<Festival> festivals;
    private ArrayList<Site> sites;

    public History() {
        dynasties = new ArrayList<Dynasty>();
        festivals = new ArrayList<Festival>();
        sites = new ArrayList<Site>();
    }

    public ArrayList<Dynasty> getDynasties() {
        return dynasties;
    }

    public ArrayList<Festival> getFestivals() {
        return festivals;
    }

    public ArrayList<Site> getSites() {
        return sites;
    }

    public Dynasty findDynasty(String name) {
        for (Dynasty dynasty : dynasties) {
            if(dynasty.getName().equals(name)) {
                return dynasty;
            }
        }
        return null;
    }
    public Human findHuman(String name) {
        for (Dynasty dynasty : dynasties) {
            Human human =dynasty.findHuman(name);
            if (human != null)
                return human;
        }
        return null;
    }
    public void write() {
        JSONArray jsonDynasties = new JSONArray();
        JSONArray jsonEvents = new JSONArray();
        JSONArray jsonMonarch = new JSONArray();
        JSONArray jsonFigure = new JSONArray();
        for (Dynasty dynasty : dynasties) {
            JSONObject jsObj = dynasty.toJSON();
            jsonDynasties.put(jsObj);
            for (Event event : dynasty.getEvents()) {
                JSONObject jsObjE = event.toJSON();
                jsonEvents.put(jsObjE);
            }
            for (Human human : dynasty.getHumanArrayList()) {
                if(human instanceof Monarch)
                    jsonMonarch.put(human.toJSON());
                if(human instanceof Figure)
                    jsonFigure.put(human.toJSON());
            }
        }
        JSONArray jsonFestivals = new JSONArray();
        for (Festival festival : festivals) {
            JSONObject jsObj = festival.toJSON();
            jsonFestivals.put(jsObj);
        }
        JSONArray jsonSites = new JSONArray();
        for (Site site : sites) {
            JSONObject jsObj = site.toJSON();
            jsonSites.put(jsObj);
        }
        toFile(jsonDynasties, "./output/dynasty.json");
        toFile(jsonEvents, "./output/event.json");
        toFile(jsonMonarch, "./output/monarch.json");
        toFile(jsonFigure, "./output/figure.json");
        toFile(jsonFestivals, "./output/festival.json");
        toFile(jsonSites, "./output/site.json");
    }

    private static void toFile(JSONArray jsA, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsA.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
