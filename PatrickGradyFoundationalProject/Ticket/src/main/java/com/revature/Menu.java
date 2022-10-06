package com.revature;

import com.revature.models.User;

import java.util.Scanner;

public class Menu {
    public static int menu(User user) {
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
