package com.revature;

import com.revature.models.User;
import com.revature.services.ReportService;
import com.revature.services.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("This App is no longer utilizing the comaand line.");
//        User user = null;
//        UserService us = new UserService();
//        ReportService rs = new ReportService();
//
//        boolean running = true;
//        int choice;
//
//        // user is not yet logged in so allow them to create a new user
//        // or log in to existing user
//        while (running) {
//            choice = Menu.menu(user);
//            if (choice == 1) {
////                user = us.create();  // create a new user
//            } else if (choice == 2) {
////                user = us.login();  // login to existing user
//            } else if (choice == 3) {
//                running = false; // exit the program
//            }
//
//            // user is logged in so see what they want to do next
//            if (choice == 4) {
//                assert user != null;
//                rs.create(user); // create a new expense report for logged in user
//            } else if (choice == 5) {
//                ArrayList<User> employee = us.getAll();
//                for (User e : employee) {
//                    System.out.println(e);
//                }
//            } else if(choice == 6){
//                Scanner sc = new Scanner(System.in);
//                int id = Integer.parseInt(sc.nextLine());
//                User userById = us.getUserById(id);
//                System.out.println(userById);
//            } else if (choice == 10) {
//                user = null; // log out
//            } else if (choice == 11){
//                running = false; // exit the app
//            }
//        }
    }


}
