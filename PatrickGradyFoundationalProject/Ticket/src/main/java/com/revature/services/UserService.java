package com.revature.services;

import com.revature.models.User;

import java.util.Scanner;

public class UserService {
        public User create() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter your first name: ");
                String fName = sc.nextLine();
                System.out.println("Please enter your last name: ");
                String lName = sc.nextLine();
                System.out.println("Please enter your user name: ");
                String uname = sc.nextLine();
                System.out.println("Please enter your password: ");
                String password = sc.nextLine();

                User user = new User(fName, lName, uname, password);

                System.out.println("Creating User in database......");
//                Connect conn = new Connect();
//                User user = conn.createUser(this);

                return user;
        }

        public User login() {
                Scanner sc = new Scanner(System.in);
                System.out.println("User Name: ");
                String name = sc.nextLine();
                System.out.println("Password ");
                String password = sc.nextLine();

                System.out.println("Retrieving User from database.......");

//                Connect conn = new Connect();
//                User user = conn.login(name, password);
//
//                if (user == null){
//                        exit(1);
//                }
                return null;

        }
}
