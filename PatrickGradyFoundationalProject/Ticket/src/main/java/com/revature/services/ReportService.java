package com.revature.services;

import com.revature.Exceptions.DescriptionCannotBeBlankError;
import com.revature.Exceptions.NonPositiveAmountError;
import com.revature.dao.ReportDAOImpl;
import com.revature.models.*;
import java.util.ArrayList;
import java.util.List;

public class ReportService {
    ReportDAOImpl reportDAO = new ReportDAOImpl();

    // method to create new report for a logged-in user
    public Report create(Report report) throws NonPositiveAmountError, DescriptionCannotBeBlankError {
        // userid , amount, description
        if (report.getAmount() < 0) {
            throw new NonPositiveAmountError();
        }else if (report.getDescription().trim().equals("")) {
            throw new DescriptionCannotBeBlankError();
        }
        return reportDAO.createReport(report);
    }

    public ArrayList<Report> getAll() {
        return reportDAO.getAllReports();

    }

    public List<Report> getAllByPending() {
        return reportDAO.getAllByPending();
    }

    public List<Report> getAllByUserId(int id) {
        return reportDAO.getAllByUserId(id);
    }

    public Report getReportById(int id) {
        return reportDAO.getReportById(id);
    }

    public Report Approve(int id){
        return reportDAO.ApproveReport(id);
    }

    public Report Deny(int id){
        return reportDAO.DenyReport(id);
    }
}
