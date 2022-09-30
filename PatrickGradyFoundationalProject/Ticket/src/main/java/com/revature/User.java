package com.revature;

import java.util.Scanner;
public class User {
    private String fName;
    private String lName;
    private String uName;
    private String password;

    public User() {}

    public User(String fName, String lName, String uName, String password) {
        this.fName = fName;
        this.lName = lName;
        this.uName = uName;
        this.password = password;
    }

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
        Connect conn = new Connect();
        conn.create(this);

        return this;
    }

    public User login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("User Name: ");
        String name = sc.nextLine();
        System.out.println("Password ");
        String password = sc.nextLine();

        System.out.println("Retrieving User from database.......");

        Connect conn = new Connect();
        User user = conn.login(name, password);

        return new User("pat", "grady", "pgrady", "pass1234");

    }

    /**
     * @return String return the fName
     */
    public String getFName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setFName(String fName) {
        this.fName = fName;
    }

    /**
     * @return String return the lName
     */
    public String getLName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setLName(String lName) {
        this.lName = lName;
    }

    /**
     * @return String return the uName
     */
    public String getUName() {
        return uName;
    }

    /**
     * @param uName the uName to set
     */
    public void setUName(String uName) {
        this.uName = uName;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}