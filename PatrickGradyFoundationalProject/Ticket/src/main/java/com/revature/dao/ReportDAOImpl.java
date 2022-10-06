package com.revature.dao;

import com.revature.models.Report;
import com.revature.models.User;
import com.revature.util.ConnectUtil;

import java.sql.*;
import java.util.ArrayList;


public class ReportDAOImpl implements ReportDAO {
    @Override
    public void createReport(Report report, User user) {
        try (Connection conn = ConnectUtil.connect()) {
            try {
                String query = "INSERT INTO reports (userid, amount, description) VALUES (?,?,?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, user.getId());
                statement.setFloat(2, report.getAmount());
                statement.setString(3, report.getDescription());
                statement.executeUpdate();

                System.out.println("Successfully Added Report for " + user.getuName() + " to the database");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Report> getAllReports(User user) {
        ArrayList<Report> reports = new ArrayList<>();

        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "SELECT * FROM public.reports WHERE userid = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, user.getId());
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    int u = rs.getInt("userid");
                    float a = rs.getFloat("amount");
                    String d = rs.getString("description");
                    String s = rs.getString("status");
                    Date t = rs.getDate("date");
                    reports.add(new Report(u, a, d, s, t));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        
        return reports;
    }
}
