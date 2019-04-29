package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class House {
    private int id;
    private String landlord;
    private String name;
    private String picture;
    private String location;
    private String category;
    private String area;
    private String floor;
    private int price;
    private String publishdate;
    private boolean ischeck;
    private boolean islease;

    public House() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLandlord() {
        return landlord;
    }

    public void setLandlord(String landlord) {
        this.landlord = landlord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public boolean isIscheck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }

    public boolean isIslease() {
        return islease;
    }

    public void setIslease(boolean islease) {
        this.islease = islease;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", landlord='" + landlord + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", location='" + location + '\'' +
                ", category='" + category + '\'' +
                ", area='" + area + '\'' +
                ", floor='" + floor + '\'' +
                ", price='" + price + '\'' +
                ", publishdate='" + publishdate + '\'' +
                ", ischeck=" + ischeck +
                ", islease=" + islease +
                '}';
    }
}
