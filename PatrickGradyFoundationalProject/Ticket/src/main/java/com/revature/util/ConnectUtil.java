package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectUtil {
        // database url
        static final String DB_URL = "jdbc:postgresql://revature.c1pvzhhqjbhw.us-east-1.rds.amazonaws.com:5432/postgres";

        // credentials
        static final String USER = System.getenv("DB_USER");
        static final String PASS = System.getenv("DB_PASS");

        public static Connection connect() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch(Exception e){
                e.printStackTrace();
            }
            return conn;
        }
}
