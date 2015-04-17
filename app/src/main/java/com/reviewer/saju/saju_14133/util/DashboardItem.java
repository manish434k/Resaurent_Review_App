package com.reviewer.saju.saju_14133.util;

/**
 * Created by Manish on 4/16/2015.
 */
public class DashboardItem {
    private String restName;
    private String address;
    private String date;
    private String time;
    private int bill;
    private float rating;

    public DashboardItem(String restName, String address, String date, String time, int bill, float rating) {
        this.restName = restName;
        this.address = address;
        this.date = date;
        this.time = time;
        this.bill = bill;
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
