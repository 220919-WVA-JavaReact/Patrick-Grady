package com.revature.dao;

import com.revature.models.Report;
import com.revature.models.User;

import java.util.ArrayList;

public interface ReportDAO {
    void createReport(Report report, User user);
    ArrayList<Report> getAllReports(User user);
}
