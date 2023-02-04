package com.hust.historical;

import com.hust.historical.model.HistoricalObject;

import java.util.*;

public class HistoricalList {
    private ArrayList<HistoricalObject> historicalObjects;

    public HistoricalList() {
        historicalObjects = new ArrayList<HistoricalObject>();
    }

    public ArrayList<HistoricalObject> getHistoricalObjects() {
        return historicalObjects;
    }

    public boolean addHistoricalObject(HistoricalObject historicalObject) {
        if (historicalObjects.contains(historicalObject))
            return false;
        historicalObjects.add(historicalObject);
        return true;
    }

    public boolean removeHistoricalObject(HistoricalObject historicalObject) {
        if (!historicalObjects.contains(historicalObject))
            return false;
        historicalObjects.remove(historicalObject);
        return true;
    }

    public HistoricalObject findHistoricalObject(String name) {
        for (HistoricalObject historicalObject : historicalObjects) {
            if (historicalObject.getName().equals(name))
                return historicalObject;
        }
        return null;
    }
}