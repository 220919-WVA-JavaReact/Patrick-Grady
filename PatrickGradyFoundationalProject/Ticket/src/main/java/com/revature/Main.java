package com.revature;

//import com.revature.modles.Report;
import com.revature.modles.User;

import com.revature.services.Report;
//import com.revature.services.User;

public class Main {
    public static void main(String[] args) {
            User user = null;

            // user is not yet logged in so allow them to create a new user
            // or log in to existing user
            int choice = Menu.show(user);
            if (choice == 1) {
                user = new User().create();
            } else if ( choice == 2) {
                user = new User().login();
            }

            // user is logged in so see what they want to do next
            choice = Menu.show(user);
            if (choice == 3) {
                Report.create(user);
            } else if (choice == 4) {
                Report.printAllReports(user);
            }
        }
    }