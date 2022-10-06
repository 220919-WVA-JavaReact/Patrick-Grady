package com.revature.services;

import com.revature.dao.ReportDAOImpl;
import com.revature.models.Report;
import com.revature.models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ReportService {
    ReportDAOImpl rdao = new ReportDAOImpl();

    // method to create new report for a logged in user
    public void create(User user){

        Scanner fsc = new Scanner(System.in);
        Scanner ssc = new Scanner(System.in);
        System.out.println("Please Enter the amount: ");
        float amount = fsc.nextFloat();
        System.out.println("Please Enter the description: ");
        String desc = ssc.nextLine();

        System.out.println("Creating report..");
        Report report = new Report(user.getId(), amount, desc);

        rdao.createReport(report, user);
    }

    public void printAllReports(User user) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Report> reports = rdao.getAllReports(user);
        System.out.println(reports.size() + " Reports for " + user.getfName() + " " + user.getlName());

        for (Report report : reports) {
            System.out.println("-----------------------------------------------------");
            System.out.println(user.getfName() + " " + user.getlName());
            System.out.println("Amount: " + report.getAmount());
            System.out.println("For " + report.getDescription());
            System.out.println("On " +report.getDate());
            System.out.println("Status: " + report.getStatus());
            System.out.println("Press Enter to Continue...");
            sc.nextLine();
        }
        System.out.println("Press Enter to Go Back to the Menu...");
        sc.nextLine();
    }
}
