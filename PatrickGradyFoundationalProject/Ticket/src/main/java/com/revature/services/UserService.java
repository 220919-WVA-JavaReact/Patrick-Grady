package com.revature.services;

import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

import java.util.Scanner;

public class UserService {
        UserDAOImpl udao = new UserDAOImpl();
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
                udao.createUser(user);

                return user;
        }

        public User login() {
                Scanner sc = new Scanner(System.in);
                System.out.println("User Name: ");
                String uname = sc.nextLine();
                System.out.println("Password ");
                String password = sc.nextLine();

                System.out.println("Retrieving User from database.......");
                User user = udao.loginUser(uname, password);

                return user;

        }
}
