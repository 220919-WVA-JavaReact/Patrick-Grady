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
        int choice = mainMenu(user);
        if (choice == 1) {
            user = us.create();
        } else if ( choice == 2) {
            user = us.login();
        }

        // user is logged in so see what they want to do next
        choice = mainMenu(user);
        if (choice == 3) {
            Report rep = rs.create(user);
        } else if (choice == 4) {
            rs.printAllReports(user);
        }
    }

    public static int mainMenu(User user) {
        int input = 0;
        if (user == null) {
            System.out.println("Ticket Reimbursement System");
            System.out.println("What would you like to do? ");
            System.out.println("1) Create New User ");
            System.out.println("2) Log in to Existing User ");
        } else {
            System.out.println("What would you like to do next " + user.getuName());
            System.out.println("3) Create Expense Report ");
            System.out.println("4) See All Your Expense Reports ");
            System.out.println("5) Exit ");

        }

        // get user input from the keyboard
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
        return input;
    }
}
