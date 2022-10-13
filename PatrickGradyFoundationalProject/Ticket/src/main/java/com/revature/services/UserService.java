package com.revature.services;

import com.revature.dao.HelperDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;
import com.revature.util.Helper;

import java.util.Scanner;

public class UserService {
    UserDAOImpl udao;

    public UserService() {
        udao = new UserDAOImpl();
    }

    public UserService(UserDAOImpl udao) {
        this.udao = udao;
    }

    public User create() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        do {
            System.out.println("Please enter your first name: ");
            input = sc.nextLine();
        } while (!Helper.isNotEmpty(input));
        String fName = input;
        do {
            System.out.println("Please enter your last name: ");
            input = sc.nextLine();
        } while (!Helper.isNotEmpty(input));
        String lName = input;
        String uname = null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter your user name: ");
            uname = sc.nextLine();
            valid = HelperDAO.checkIfUserNameIsTaken(uname);
        }
        do {
            System.out.println("Please enter your password: ");
            input  = sc.nextLine();
        } while (!Helper.isNotEmpty(input));
        String password = input;

        User user = new User(fName, lName, uname, password);

        System.out.println("Creating User in database......");

        return udao.createUser(user);
    }

    public User login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("User Name: ");
        String uname = sc.nextLine();
        System.out.println("Password ");
        String password = sc.nextLine();

        System.out.println("Retrieving User from database.......");

        return udao.loginUser(uname, password);

    }

    public void promote(User manager, User employee) {
        if (manager.getRole().equals("Employee")){
            System.out.println("Employees must be promoted by managers");
            return;
        }
        if (employee.getRole().equals("Manager")){
            System.out.println(employee.getuName() + " is already a manager");
            return;
        }
        employee.setRole("Manager");
    }

    public void demote(User manager, User employee) {
        if (manager.getRole().equals("Employee")){
            System.out.println("Employees must be promoted by managers");
            return;
        }
        if (employee.getRole().equals("Manager")){
            System.out.println(employee.getuName() + " is already a manager");
            return;
        }
        if (employee.getId() == manager.getId()){
            System.out.println("You cannot demote yourself");
        }
        employee.setRole("Employee");
    }
}
