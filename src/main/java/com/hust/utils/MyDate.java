package com.hust.utils;

public class MyDate {
    private int day;
    private int month;
    private int year;
    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public MyDate(int month, int year) {
        this.day = -1;
        this.month = month;
        this.year = year;
    }
    public MyDate(int year) {
        this.day = -1;
        this.month = -1;
        this.year = year;
    }
    public MyDate(String date) {
        if(!date.contains("/") && !date.contains(" "))
            this.year = Integer.parseInt(date);
    }
    public MyDate() {
        this.day = -1;
        this.month = -1;
        this.year = -1;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        if(day == -1 && month == -1)
            return year + "";
        if(day == -1)
            return month + "/" + year;
        if(day == 0 && month == 0)
            return year + "";
        if(day == 0)
            return month + "/" + year;
        return day + "/" + month + "/" + year;
    }

}
