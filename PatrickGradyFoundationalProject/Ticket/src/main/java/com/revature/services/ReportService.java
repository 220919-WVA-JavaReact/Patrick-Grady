package com.revature.services;

import com.revature.dao.ReportDAOImpl;
import com.revature.models.*;
import com.revature.util.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportService {
    ReportDAOImpl reportDAO = new ReportDAOImpl();

    // method to create new report for a logged in user
    public Message create(Report report){
        // userid , amount, description
        if (report.getAmount() < 0) {
            return new ErrorMessage(400, "amount must be positive");
        }else if (report.getDescription().trim().equals("")) {
            return new ErrorMessage(400, "Description cannot be blank");
        }
        reportDAO.createReport(report);
        return new OkMessage("Created Report");
    }

    public ArrayList<Report> getAll() {
        return reportDAO.getAllReports();

    }

    public List<Report> getAllByPending() {
        return reportDAO.getAllByPending();
    }

    public List<Report> getReportById(int id) {
        return reportDAO.getReportById(id);
    }
}
