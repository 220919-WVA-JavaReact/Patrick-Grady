package Ticket;

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

    public User create( User user ) {
        Connection conn = null;
        Statement statement = null;

        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected...");
            
            statement = conn.createStatement();

            String sql = "INSERT INTO users (fName, lName, uName, password) VALUES ('" + user.getFName()+"' ,'"
                                                                                      + user.getLName()+"' ,'"
                                                                                      + user.getUName()+"' ,'"
                                                                                      + user.getPassword()+"');";

            statement.executeUpdate(sql);
            System.out.println("Successfully Added " + user.getUName() + " to the database");
            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Failed :(");
            System.err.println(e.getClass().getName()+ ": " + e.getMessage());
            System.exit(0);
        }
        return user;
    }

    // public User login() {}
}
