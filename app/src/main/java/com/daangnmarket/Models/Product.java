package com.daangnmarket.Models;

import java.util.Date;

public class Product {
    private String title;
    private String location;
    private int price;
    private Date registerTime;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public String getPriceString() {
        return String.format("%,d" , price);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public String getRegisterTimeString() {
        Date currentTime = new Date();

        long startTime = registerTime.getTime();
        long endTime = currentTime.getTime();

        long totlaTime = endTime - startTime;

        return String.format("%d 초전",totlaTime);
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
