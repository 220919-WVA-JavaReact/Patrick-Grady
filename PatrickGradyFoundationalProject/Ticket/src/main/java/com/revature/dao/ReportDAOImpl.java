package com.revature.dao;

import com.revature.models.*;
import com.revature.util.ConnectUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReportDAOImpl implements ReportDAO {
    @Override
    public Report createReport(Report report) {
        try (Connection conn = ConnectUtil.connect()) {
            try {
                String query = "INSERT INTO reports (userid, amount, description) VALUES (?,?,?) RETURNING *";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, report.getUserId());
                statement.setFloat(2, report.getAmount());
                statement.setString(3, report.getDescription());
                ResultSet rs = statement.executeQuery();
                if (rs.next()){
                    int id = rs.getInt("id");
                    int userid = rs.getInt("userid");
                    float amount = rs.getFloat("amount");
                    String description = rs.getString("description");
                    String status = rs.getString("status");
                    Date date = rs.getDate("date");

                    return new Report(id, userid, amount, description, status, date);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Report> getAllReports() {
        ArrayList<Report> reports = new ArrayList<>();

        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "SELECT * FROM public.reports ORDER BY id";
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
                String query = "SELECT * FROM public.reports WHERE status = ? ORDER BY id";
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

        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "SELECT * FROM public.reports WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    int i = rs.getInt("id");
                    int u = rs.getInt("userid");
                    float a = rs.getFloat("amount");
                    String d = rs.getString("description");
                    String s = rs.getString("status");
                    Date t = rs.getDate("date");
                    return new Report(i, u, a, d, s, t);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Report ApproveReport(int id) {
        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "UPDATE public.reports SET status = 'Approved' WHERE id = ? RETURNING *;";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()){
                    int rid = rs.getInt("id");
                    System.out.println("In Deny: rid = " + rid);
                    return getReportById(rid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Report DenyReport(int id) {
        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "UPDATE public.reports SET status = 'Denied' WHERE id = ? RETURNING *;";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()){
                    int rid = rs.getInt("id");
                    System.out.println("In Deny: rid = " + rid);
                    return getReportById(rid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Report> getAllByUserId(int id){
        ArrayList<Report> reports = new ArrayList<>();

        try (Connection conn = ConnectUtil.connect()) {

            try {
                String query = "SELECT * FROM public.reports WHERE userid = ? ORDER BY id";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, id);
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
}

