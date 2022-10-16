package com.revature.dao;

import com.revature.models.*;
import com.revature.util.ConnectUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReportDAOImpl implements ReportDAO {
    @Override
    public Message createReport(Report report) {
        try (Connection conn = ConnectUtil.connect()) {
            try {
                String query = "INSERT INTO reports (userid, amount, description) VALUES (?,?,?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, report.getUserId());
                statement.setFloat(2, report.getAmount());
                statement.setString(3, report.getDescription());
                ResultSet rs = statement.executeQuery();
                if (rs.next()){
                    return new OkMessage(report);
//                    SWAGGER UI???????
//                    current user header
//                    author and resolver
//                    put status denied / approved?
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ErrorMessage(500, "Could not save report to the database");
    }

    @Override
    public ArrayList<Report> getAllReports() {
        ArrayList<Report> reports = new ArrayList<>();

        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "SELECT * FROM public.reports";
                PreparedStatement statement = conn.prepareStatement(query);
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

    @Override
    public List<Report> getAllByPending() {
        ArrayList<Report> reports = new ArrayList<>();

        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "SELECT * FROM public.reports WHERE status = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, "Pending");
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

    @Override
    public List<Report> getReportById(int id) {
        ArrayList<Report> reports = new ArrayList<>();

        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "SELECT * FROM public.reports WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, id);
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
