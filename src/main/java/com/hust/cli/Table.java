package com.hust.cli;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Table {
    private JSONArray jsonArray;
    public Table(String file) {
        InputStream is = getClass().getResourceAsStream("/output/" + file);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + file);
        }
        JSONTokener token = new JSONTokener(is);
        jsonArray = new JSONArray(token);
        int size = jsonArray.length();
        ArrayList<String> header = new ArrayList<>();

        // Get the header row
        if (jsonArray.length() > 0) {
            JSONObject firstRow = (JSONObject) jsonArray.get(0);
            header.addAll(firstRow.keySet());
        }

        // Create the ASCII table
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(header);
        at.addRule();
        for (int i = 0; i < 5; i++) {
            JSONObject row = (JSONObject) jsonArray.get(i);
            ArrayList<String> values = new ArrayList<>();
            for (String h : header) {
                String value = row.getString(h);
                if (h.equals("nhân vật liên quan")) {
                    if (value.length() > 50) {
                        value = value.substring(0, 50);
                        value += "...";
                    }
                }
                values.add(value);
            }
            at.addRow(values);
            at.addRule();
        }
        at.getContext().setWidth(150);
        System.out.println(at.render());
    }
}
