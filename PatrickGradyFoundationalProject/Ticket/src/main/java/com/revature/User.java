package com.revature;

import java.util.Scanner;

import static java.lang.System.exit;

public class User {
    private int id;
    private String fName;
    private String lName;
    private String uName;
    private String password;
    private Boolean manager;

    public User create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        this.fName = sc.nextLine();
        System.out.println("Please enter your last name: ");
        this.lName = sc.nextLine();
        System.out.println("Please enter your user name: ");
        this.uName = sc.nextLine();
        System.out.println("Please enter your password: ");
        this.password = sc.nextLine();

        System.out.println("Creating User in database......");

        return Connect.createUser(this);
    }

    public User login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("User Name: ");
        String name = sc.nextLine();
        System.out.println("Password ");
        String password = sc.nextLine();

        System.out.println("Retrieving User from database.......");

        User user = Connect.login(name, password);

        if (user == null){
            System.out.println("Problem with the Database!");
            exit(1);
        }
        return user;
    }

    // Constructors

    public User() {}

    public User(int id, String fName, String lName, String uName, String password, Boolean manager) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.uName = uName;
        this.password = password;
        this.manager = manager;
    }

    // Getters

    public String getFName() { return fName; }
    public String getLName() { return lName; }
    public String getUName() { return uName; }
    public String getPassword() { return password; }
    public Boolean getManager() { return manager; }
    public int getId() { return id; }
}