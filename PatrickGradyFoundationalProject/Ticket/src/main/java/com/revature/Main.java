package com.revature;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            User user = null;

            // user is not yet logged in so allow them to create a new user
            // or log in to existing user
            int choice = mainMenu(user);
            if (choice == 1) {
                user = new User().create();
            } else if ( choice == 2) {
                user = new User().login();
            }

            // user is logged in so see what they want to do next
            choice = mainMenu(user);
            if (choice == 3) {
                Report rep = new Report();
                rep = rep.create(user);
            } else if (choice == 4) {
                Report.printAllReports(user);
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
                System.out.println("What would you like to do next " + user.getUName());
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