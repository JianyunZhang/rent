package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Checklog {
    private String id;
    private String admin;
    private int house;
    private String checkdate;
    private boolean checkresult;

    public Checklog() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public String getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(String checkdate) {
        this.checkdate = checkdate;
    }

    public boolean isCheckresult() {
        return checkresult;
    }

    public void setCheckresult(boolean checkresult) {
        this.checkresult = checkresult;
    }

    @Override
    public String toString() {
        return "Checklog{" +
                "id='" + id + '\'' +
                ", admin='" + admin + '\'' +
                ", house=" + house +
                ", checkdate='" + checkdate + '\'' +
                ", checkresult=" + checkresult +
                '}';
    }
}
