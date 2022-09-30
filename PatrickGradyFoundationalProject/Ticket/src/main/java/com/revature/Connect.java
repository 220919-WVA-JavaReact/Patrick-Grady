package com.revature;

import java.sql.*;

public class Connect {
    //JDBC driver name and database url
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://revature.c1pvzhhqjbhw.us-east-1.rds.amazonaws.com:5432/postgres";

    // credentials
    static final String USER = System.getenv("DB_USER");
    static final String PASS = System.getenv("DB_PASS");

    public void connect() {
        // deprecated
    }

    public void create( User user ) {

        try {
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected...");

            Statement statement = conn.createStatement();

            String query = "INSERT INTO users (fName, lName, uName, password) VALUES ('" + user.getFName()+"' ,'"
                    + user.getLName()+"' ,'"
                    + user.getUName()+"' ,'"
                    + user.getPassword()+"');";

            statement.executeUpdate(query);
            System.out.println("Successfully Added " + user.getUName() + " to the database");
            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Failed :(");
            System.err.println(e.getClass().getName()+ ": " + e.getMessage());
            System.exit(0);
        }
    }

     public User login(String uName, String password) {
        User user = null;
         try {
             System.out.println("Connecting to database...");
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             System.out.println("Connected...");
             Statement statement = conn.createStatement();


             String query = "SELECT * FROM users WHERE uName=" + uName;
             try {
                 int res = statement.executeUpdate(query);
                 System.out.println(res);
             } catch (Exception e) {
                 return null;
             }
         } catch (Exception e) {
             System.out.println("Failed :(");
             System.err.println(e.getClass().getName()+ ": " + e.getMessage());
             System.exit(0);
         }

         return user;
     }
}
