package com.revature.dao;

import com.revature.models.User;
import com.revature.util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                String r = rs.getString("role");

                user = new User(i, f, l, u, p, r);
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
        try (Connection conn = ConnectUtil.connect()) {
            try {
                String query = "SELECT * FROM users WHERE uname = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, uname);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    int i = rs.getInt("id");
                    String f = rs.getString("fname");
                    String l = rs.getString("lname");
                    String u = rs.getString("uname");
                    String p = rs.getString("password");
                    String r = rs.getString("role");
                    if (p.equals(password)) {
                        return new User(i, f, l, u, p, r);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Invalid Credentials! Try Logging In Again!");
        return null;
    }

    public ArrayList<User> getAllEmployees(){
        ArrayList<User> employees = new ArrayList<>();
        try (Connection conn = ConnectUtil.connect()) {
            try {
                String query = "SELECT * FROM users";
                PreparedStatement statement = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = statement.executeQuery();
//                count number of rows that came back
                int rowCount = 0;
                if(rs.last()){
                    rowCount = rs.getRow();
                    rs.beforeFirst();
                }
                System.out.println(rowCount);

                while (rs.next()) {
                    int i = rs.getInt("id");
                    String f = rs.getString("fname");
                    String l = rs.getString("lname");
                    String u = rs.getString("uname");
                    String p = rs.getString("password");
                    String r = rs.getString("role");
                    employees.add(new User(i, f, l, u, p, r));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return employees;
    }

    public User getEmployeeById(int id) {
        User user = null;
        try (Connection conn = ConnectUtil.connect()) {
            try {
                String query = "SELECT * FROM users WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                rs.next();
                int i = rs.getInt("id");
                String f = rs.getString("fname");
                String l = rs.getString("lname");
                String u = rs.getString("uname");
                String p = rs.getString("password");
                String r = rs.getString("role");

                user = new User(i, f, l, u, p, r);
                statement.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User deleteEmployee(int id){
        try (Connection conn = ConnectUtil.connect()) {
            try {
                String query = "DELETE FROM users WHERE uname = ? RETURNING *;";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                rs.next();
                int i = rs.getInt("id");
                String f = rs.getString("fname");
                String l = rs.getString("lname");
                String u = rs.getString("uname");
                String p = rs.getString("password");
                String r = rs.getString("role");

                return new User(i, f, l, u, p, r);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
