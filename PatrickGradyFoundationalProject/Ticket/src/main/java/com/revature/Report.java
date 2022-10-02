package com.revature;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Report {
    private int id;
    private int userid;
    private float amount;
    private String description;
    private String status;
    private Date date;


    // method to create new report for a logged in user
    public Report create(User user){
        int uid = user.getId();

        Scanner fsc = new Scanner(System.in);
        Scanner ssc = new Scanner(System.in);
        System.out.println("Please Enter the amount: ");
        float amount = fsc.nextFloat();
        System.out.println("Please Enter the description: ");
        String desc = ssc.nextLine();

        System.out.println("Creating report..");
        Report report = new Report(uid, amount, desc);
        System.out.println(uid + "  " + amount + "   " + desc);

        System.out.println("Created new report for " + user.getUName());
        System.out.println();

        Connect.createReport(report, user);

        return report;
    }

    public static void printAllReports(User user) {
        ArrayList<Report> reports = Connect.getAllReports(user);
        System.out.println(reports.size());

        for (Report report : reports) {
            System.out.println("-----------------------------------------------------");
            System.out.println(user.getFName() + " " + user.getLName());
            System.out.println("Amount: " + report.getAmount());
            System.out.println("For " + report.getDescription());
            System.out.println("On " +report.getDate());
            System.out.println("Status: " + report.getStatus());
        }
    }

    // other fields are either serial or has default values
    public Report(int userid, float amount, String description) {
        this.userid = userid;
        this.amount = amount;
        this.description = description;
    }

    // full constructor for printing
    public Report(int userid, float amount, String description, String status, Date date) {
        this.userid = userid;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    // empty constructor
    public Report(){}

    // getters and setters
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
