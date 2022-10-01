package com.revature;

import java.time.LocalDateTime;

public class Report {
    private int id;
    private int userid;
    private float amount;
    private String description;
    private String status;
    private LocalDateTime date;

    public Report(int userid, float amount, String description, String status) {
        this.userid = userid;
        this.amount = amount;
        this.description = description;
        this.status = status;
    }

    public Report(int id, int userid, float amount, String description, String status, LocalDateTime date) {
        this.id = id;
        this.userid = userid;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
