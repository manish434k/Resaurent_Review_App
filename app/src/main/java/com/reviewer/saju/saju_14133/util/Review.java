package com.reviewer.saju.saju_14133.util;

/**
 * Created by Manish on 4/15/2015.
 */
public class Review {

    //private variables
    int id;
    String name;
    String date;
    String time;
    String address;
    int companion;
    int bill;
    int tip;
    float rating_food;
    float rating_wine;
    float rating_ambiance;
    float rating_staff;
    float rating_overall;

    // Empty constructor
    public Review(){

    }
    // constructor
    public Review(int id,String name,String date,String time,String address,int companion,int bill,int tip,
                  float rating_food,
                  float rating_wine, float rating_ambiance,
                  float rating_staff, float rating_overall){
        this.id = id;
        this.name = name;
        this.date =date;
        this.time =time;
        this.address =address;
        this.companion =companion;
        this.bill =bill;
        this.tip =tip;
        //rating
        this.rating_food = rating_food;
        this.rating_wine = rating_wine;
        this.rating_ambiance = rating_ambiance;
        this.rating_staff = rating_staff;
        this.rating_overall = rating_overall;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCompanion() {
        return companion;
    }

    public void setCompanion(int companion) {
        this.companion = companion;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public float getRating_food() {
        return rating_food;
    }

    public void setRating_food(int rating_food) {
        this.rating_food = rating_food;
    }

    public float getRating_wine() {
        return rating_wine;
    }

    public void setRating_wine(int rating_wine) {
        this.rating_wine = rating_wine;
    }

    public float getRating_ambiance() {
        return rating_ambiance;
    }

    public void setRating_ambiance(int rating_ambiance) {
        this.rating_ambiance = rating_ambiance;
    }

    public float getRating_staff() {
        return rating_staff;
    }

    public void setRating_staff(int rating_staff) {
        this.rating_staff = rating_staff;
    }

    public float getRating_overall() {
        return rating_overall;
    }

    public void setRating_overall(int rating_overall) {
        this.rating_overall = rating_overall;
    }

}

