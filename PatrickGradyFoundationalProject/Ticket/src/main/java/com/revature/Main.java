package com.revature;

import com.revature.models.Report;
import com.revature.models.User;
import com.revature.services.ReportService;
import com.revature.services.UserService;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        User user = null;
        UserService us = new UserService();
        ReportService rs = new ReportService();

        // user is not yet logged in so allow them to create a new user
        // or log in to existing user
        int choice = Menu.menu(user);
        if (choice == 1) {
            user = us.create();
        } else if ( choice == 2) {
            user = us.login();
        }

        // user is logged in so see what they want to do next
        choice = Menu.menu(user);
        if (choice == 3) {
            Report rep = rs.create(user);
        } else if (choice == 4) {
            rs.printAllReports(user);
        }
    }


}
