package com.revature.dao;

import com.revature.util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelperDAO {
    public static boolean IsUserNameTaken(String uname) {
        boolean valid = true;
        try (Connection conn = ConnectUtil.connect()) {
            String query = "SELECT COUNT(*) FROM users WHERE uname = ?";
            conn.prepareStatement(query);
            PreparedStatement statement;
            statement = conn.prepareStatement(query);
            statement.setString(1, uname);
            ResultSet rs = statement.executeQuery();
            rs.next();
            if (rs.getInt("count") != 0) {
                System.out.println("Username is taken!");
            } else {
                valid = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valid;
    }
}
