package com.revature.modles;

public class User {
    private int id;
    private String fName;
    private String lName;
    private String uName;
    private String password;
    private Boolean manager;

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