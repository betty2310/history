package com.hust.crawler.link;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public abstract class AbstractLink implements Link {
    private String url;
    private ArrayList<ArrayList<String>> data;
    protected String[] properties;

    public AbstractLink(String url) {
        this.url = url;
        data = new ArrayList<ArrayList<String>>();
    }
    protected ArrayList<ArrayList<String>> getData() {
        return data;
    }
    protected abstract void setProperties();
    public void writeToFile(String fileName) {
        setProperties();
        String filePath = baseFilePath + fileName;
        System.out.println("Begin crawling " + url);
        crawl(url);
        System.out.println("Finish crawling and write to file: " + filePath);
        JSONArray jsonArray = new JSONArray();
        for (ArrayList<String> item : data) {
            JSONObject obj = new JSONObject();
            for (int i = 0; i < item.size(); ++i) {
                obj.put(properties[i], item.get(i));
            }
            jsonArray.put(obj);
        }
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonArray.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
