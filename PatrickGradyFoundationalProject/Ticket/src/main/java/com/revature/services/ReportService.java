package com.revature.services;

import com.revature.models.Report;
import com.revature.models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ReportService {
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

        System.out.println("Created new report for " + user.getuName());
        System.out.println();

//        Connect conn = new Connect();
//        conn.createReport(report, user);

        return report;
    }

//    public static void printAllReports(User user) {
//        Connect conn = new Connect();
//        ArrayList<Report> reports = conn.getAllReports(user);
//        System.out.println(reports.size());
//
//        for (Report report : reports) {
//            System.out.println("-----------------------------------------------------");
//            System.out.println(user.getFName() + " " + user.getLName());
//            System.out.println("Amount: " + report.getAmount());
//            System.out.println("For " + report.getDescription());
//            System.out.println("On " +report.getDate());
//            System.out.println("Status: " + report.getStatus());
//        }
//    }
}
