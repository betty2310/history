package com.hust.historical;

import com.hust.historical.model.*;

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
}
