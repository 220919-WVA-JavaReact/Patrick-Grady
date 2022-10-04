package com.revature.services;

import com.revature.dao.Connect;
import com.revature.modles.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Report {
    // method to create new report for a logged in user
    public static com.revature.modles.Report create(com.revature.modles.User user){
        int uid = user.getId();

        Scanner fsc = new Scanner(System.in);
        Scanner ssc = new Scanner(System.in);
        System.out.println("Please Enter the amount: ");
        float amount = fsc.nextFloat();
        System.out.println("Please Enter the description: ");
        String desc = ssc.nextLine();

        System.out.println("Creating report..");
        com.revature.modles.Report report = new com.revature.modles.Report(uid, amount, desc);
        System.out.println(uid + "  " + amount + "   " + desc);

        System.out.println("Created new report for " + user.getUName());
        System.out.println();

        Connect.createReport(report, user);

        return report;
    }

    public static void printAllReports(User user) {
        ArrayList<com.revature.modles.Report> reports = Connect.getAllReports(user);
        System.out.println(reports.size());

        for (com.revature.modles.Report report : reports) {
            System.out.println("-----------------------------------------------------");
            System.out.println(user.getFName() + " " + user.getLName());
            System.out.println("Amount: " + report.getAmount());
            System.out.println("For: " + report.getDescription());
            System.out.println("On: " +report.getDate());
            System.out.println("Status: " + report.getStatus());
        }
    }
}
