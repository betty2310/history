package com.hust.historical;

import com.hust.historical.model.Dynasty;

import java.util.ArrayList;

public class TimeLine {
    private ArrayList<Dynasty> dynasties;
    public TimeLine() {
        dynasties = new ArrayList<Dynasty>();
    }
    public boolean addDynasty(Dynasty dynasty) {
        if(dynasties.contains(dynasty))
            return false;
        dynasties.add(dynasty);
        return true;
    }
    public boolean removeDynasty(Dynasty dynasty) {
        if(!dynasties.contains(dynasty))
            return false;
        dynasties.remove(dynasty);
        return true;
    }
}
