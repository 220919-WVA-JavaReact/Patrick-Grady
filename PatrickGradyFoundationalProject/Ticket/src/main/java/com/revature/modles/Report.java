package com.revature.modles;

import com.revature.dao.Connect;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Report {
    private int userid;
    private float amount;
    private String description;
    private String status;
    private Date date;

    // Constructors

    // other fields are either serial or has default values when creating a new report
    public Report(int userid, float amount, String description) {
        this.userid = userid;
        this.amount = amount;
        this.description = description;
    }

    // full constructor for use when data is pulled from database
    public Report(int userid, float amount, String description, String status, Date date) {
        this.userid = userid;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    // Getters

    public int getUserid() {
        return userid;
    }
    public float getAmount() {
        return amount;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public Date getDate() {
        return date;
    }

}
