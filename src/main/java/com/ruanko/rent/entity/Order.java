package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Order {
    private int id;
    private String landlord;
    private String leaseholder;
    private int house;
    private String orderdate;
    private int duration;
    private int price;
    private boolean state;

    public Order() {
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

    public String getLeaseholder() {
        return leaseholder;
    }

    public void setLeaseholder(String leaseholder) {
        this.leaseholder = leaseholder;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }


}
