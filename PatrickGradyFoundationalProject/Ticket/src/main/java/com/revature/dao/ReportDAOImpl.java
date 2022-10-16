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
                    int i = rs.getInt("id");
                    int u = rs.getInt("userid");
                    float a = rs.getFloat("amount");
                    String d = rs.getString("description");
                    String s = rs.getString("status");
                    Date t = rs.getDate("date");
                    reports.add(new Report(i, u, a, d, s, t));
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
                    int i = rs.getInt("id");
                    int u = rs.getInt("userid");
                    float a = rs.getFloat("amount");
                    String d = rs.getString("description");
                    String s = rs.getString("status");
                    Date t = rs.getDate("date");
                    reports.add(new Report(i, u, a, d, s, t));
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
    public Report getReportById(int id) {
        Report report = null;

        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "SELECT * FROM public.reports WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    int u = rs.getInt("userid");
                    float a = rs.getFloat("amount");
                    String d = rs.getString("description");
                    String s = rs.getString("status");
                    Date t = rs.getDate("date");
                    report = new Report(u, a, d, s, t);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return report;
    }

    @Override
    public Report ApproveReport(int id) {
        Report report = null;
        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "UPDATE public.reports SET status = 'Approved' WHERE id = ? RETURNING *;";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()){
                    rs.getInt(id);
                    report = getReportById(id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return report;
    }

    @Override
    public Report DenyReport(int id) {
        return null;
    }
}
