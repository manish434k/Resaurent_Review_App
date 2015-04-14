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

    // Empty constructor
    public Review(){

    }
    // constructor
    public Review(int id,String name,String date,String time,String address,int companion,int bill,int tip){
        this.id = id;
        this.name = name;
        this.date =date;
        this.time =time;
        this.address =address;
        this.companion =companion;
        this.bill =bill;
        this.tip =tip;
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

}

class Rating {

    int rating_id;
    int rating_food;
    int rating_wine;
    int rating_ambiance;
    int rating_staff;
    int rating_overall;

    //constructor
    public Rating()
    {

    }

    //Empty constructor
    public Rating(int rating_id,int rating_food,
            int rating_wine, int rating_ambiance,
            int rating_staff,int rating_overall)
    {

        this.rating_id = rating_id;
        this.rating_food = rating_food;
        this.rating_wine = rating_wine;
        this.rating_ambiance = rating_ambiance;
        this.rating_staff = rating_staff;
        this.rating_overall = rating_overall;

    }

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public int getRating_food() {
        return rating_food;
    }

    public void setRating_food(int rating_food) {
        this.rating_food = rating_food;
    }

    public int getRating_wine() {
        return rating_wine;
    }

    public void setRating_wine(int rating_wine) {
        this.rating_wine = rating_wine;
    }

    public int getRating_ambiance() {
        return rating_ambiance;
    }

    public void setRating_ambiance(int rating_ambiance) {
        this.rating_ambiance = rating_ambiance;
    }

    public int getRating_staff() {
        return rating_staff;
    }

    public void setRating_staff(int rating_staff) {
        this.rating_staff = rating_staff;
    }

    public int getRating_overall() {
        return rating_overall;
    }

    public void setRating_overall(int rating_overall) {
        this.rating_overall = rating_overall;
    }

}