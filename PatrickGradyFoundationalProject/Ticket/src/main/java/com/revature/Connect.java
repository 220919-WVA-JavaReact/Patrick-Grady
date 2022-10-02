package com.revature;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Connect {
    //JDBC driver name and database url
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://revature.c1pvzhhqjbhw.us-east-1.rds.amazonaws.com:5432/postgres";

    // credentials
    static final String USER = System.getenv("DB_USER");
    static final String PASS = System.getenv("DB_PASS");


    public void createUser(User user) {

        try {
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected...");

            Statement statement = conn.createStatement();

            String query = "INSERT INTO users (fName, lName, uName, password) VALUES ('" + user.getFName() + "' ,'"
                    + user.getLName() + "' ,'"
                    + user.getUName() + "' ,'"
                    + user.getPassword() + "');";

            statement.executeUpdate(query);
            System.out.println("Successfully Added " + user.getUName() + " to the database");
            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Failed :(");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public User login(String uname, String password) {
        User user = null;
        try {
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected...");


            String query = "SELECT * FROM public.users WHERE uname='" + uname + "'";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int i = rs.getInt("id");
                String f = rs.getString("fname");
                String l = rs.getString("lname");
                String u = rs.getString("uname");
                String p = rs.getString("password");
                Boolean m = rs.getBoolean("manager");

                if (p.equals(password)) {
                    user = new User(i, f, l, u, p, m);
                } else {
                    System.out.println("Wrong Login Information!");
                }
            }

        } catch (Exception e) {
            System.out.println("Failed :(");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return user;
    }

    public void createReport(Report report, User user) {
        try {
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected...");

            Statement statement = conn.createStatement();

            String query = "INSERT INTO reports (userid, amount, description) VALUES ('" + report.getUserid() + "' ,'"
                    + report.getAmount() + "' ,'"
                    + report.getDescription() + "');";

            statement.executeUpdate(query);
            System.out.println("Successfully Added Report for " + user.getUName() + " to the database");
            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Failed :(");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Report> getAllReports(User user) {
        ArrayList<Report> reports = new ArrayList<Report>();

        try {
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected...");

            String query = "SELECT * FROM public.reports WHERE userid='" + user.getId() + "'";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                int u = rs.getInt("userid");
                float a = rs.getFloat("amount");
                String d = rs.getString("description");
                String s = rs.getString("status");
                Date t = rs.getDate("date");
                reports.add(new Report(u, a, d, s, t));
            }


        } catch (Exception e) {
            System.out.println("Failed :(");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return reports;
    }
}
