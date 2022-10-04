package com.revature.dao;

import com.revature.modles.Report;
import com.revature.modles.User;

import java.sql.*;
import java.util.ArrayList;

public class Connect {
    //JDBC driver name and database url
    static final String DB_URL = "jdbc:postgresql://revature.c1pvzhhqjbhw.us-east-1.rds.amazonaws.com:5432/postgres";

    // credentials
    static final String USER = System.getenv("DB_USER");
    static final String PASS = System.getenv("DB_PASS");

    private static Connection connect() {
        Connection conn = null;
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected...");
        } catch(Exception e){
            Connect.showError(e);
        }
        return conn;
    }

    public static User createUser(User user) {
        Connection conn = Connect.connect();
        try {
            Statement statement = conn.createStatement();

            String query = "INSERT INTO users (fName, lName, uName, password) VALUES ('" + user.getFName() + "' ,'"
                    + user.getLName() + "' ,'"
                    + user.getUName() + "' ,'"
                    + user.getPassword() + "');";

            statement.executeUpdate(query);
            System.out.println("Successfully Added " + user.getUName() + " to the database");

            query = "SELECT * FROM public.users WHERE uname='" + user.getUName() + "'";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            int i = rs.getInt("id");
            String f = rs.getString("fname");
            String l = rs.getString("lname");
            String u = rs.getString("uname");
            String p = rs.getString("password");
            Boolean m = rs.getBoolean("manager");

            user = new User(i, f, l, u, p, m);
            statement.close();
            conn.close();

        } catch (Exception e) {
            Connect.showError(e);
        }

        return user;
    }

    public static User login(String uname, String password) {
        User user = null;
        Connection conn = Connect.connect();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM public.users WHERE uname='" + uname + "'";
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
            Connect.showError(e);
        }

        return user;
    }

    public static void createReport(Report report, User user) {
        Connection conn = Connect.connect();
        try {
            Statement statement = conn.createStatement();

            String query = "INSERT INTO reports (userid, amount, description) VALUES ('" + report.getUserid() + "' ,'"
                    + report.getAmount() + "' ,'"
                    + report.getDescription() + "');";

            statement.executeUpdate(query);
            System.out.println("Successfully Added Report for " + user.getUName() + " to the database");
            statement.close();
            conn.close();

        } catch (Exception e) {
            Connect.showError(e);
        }
    }

    public static ArrayList<Report> getAllReports(User user) {
        ArrayList<Report> reports = new ArrayList<>();
        Connection conn = Connect.connect();

        try {
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
            Connect.showError(e);
        }

        return reports;
    }

    private static void showError(Exception e) {
        System.out.println("Failed :(");
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
}
