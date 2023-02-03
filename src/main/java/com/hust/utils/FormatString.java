package com.hust.utils;

public class FormatString {
    private String name;
    public FormatString(String name) {
        this.name = name;
    }
    public String removeSpace() {
        return name.replaceAll("\\s+", "");
    }
}
