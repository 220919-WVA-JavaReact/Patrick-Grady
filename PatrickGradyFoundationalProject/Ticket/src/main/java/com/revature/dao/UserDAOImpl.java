package com.revature.dao;

import com.revature.models.User;
import com.revature.util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{

    @Override
    public User createUser(User user) {
        try (Connection conn = ConnectUtil.connect()) {
            try {
                String query = "INSERT INTO users (fName, lName, uName, password) VALUES (?,?,?,?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, user.getfName());
                statement.setString(2, user.getlName());
                statement.setString(3, user.getuName());
                statement.setString(4, user.getPassword());
                statement.executeUpdate();

                query = "SELECT * FROM users WHERE uname = ?";
                statement = conn.prepareStatement(query);
                statement.setString(1, user.getuName());
                ResultSet rs = statement.executeQuery();
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
                e.printStackTrace();
            }
        } catch (SQLException e) {
        e.printStackTrace();
    }
        return user;
    }

    @Override
    public User loginUser(String uname, String password) {
        User user = null;
        boolean validUserName = false;
        boolean validPassword = false;
        try (Connection conn = ConnectUtil.connect()) {
            try {
                String query = "SELECT * FROM users WHERE uname = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, uname);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    int i = rs.getInt("id");
                    String f = rs.getString("fname");
                    String l = rs.getString("lname");
                    String u = rs.getString("uname");
                    String p = rs.getString("password");
                    Boolean m = rs.getBoolean("manager");


                    // VALIDATE CREDENTIALS BETTER THAN THIS!!!
                    // AND PROBABLY EARLIER
                    if (p.equals(password)) {
                        user = new User(i, f, l, u, p, m);
                    } else {
                        System.out.println("Wrong Login Information!");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
