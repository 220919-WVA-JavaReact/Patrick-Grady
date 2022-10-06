package com.revature;

import com.revature.models.User;
import com.revature.services.ReportService;
import com.revature.services.UserService;

public class Main {
    public static void main(String[] args) {
        User user = null;
        UserService us = new UserService();
        ReportService rs = new ReportService();

        boolean running = true;
        int choice;

        // user is not yet logged in so allow them to create a new user
        // or log in to existing user
        while (running) {
            choice = Menu.menu(user);
            if (choice == 1) {
                user = us.create();  // create a new user
            } else if (choice == 2) {
                user = us.login();  // login to existing user
            } else if (choice == 3) {
                running = false; // exit the program
            }

            // user is logged in so see what they want to do next
            if (choice == 4) {
                assert user != null;
                rs.create(user); // create a new expense report for logged in user
            } else if (choice == 5) {
                rs.printAllReports(user); // show all expense reports for logged in user
            } else if (choice == 6) {
                user = null; // log out
            } else if (choice == 7){
                running = false; // exit the app
            }
        }
    }


}
