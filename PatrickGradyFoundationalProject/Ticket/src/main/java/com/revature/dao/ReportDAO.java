package com.revature.dao;

import com.revature.models.Message;
import com.revature.models.Report;
import com.revature.models.User;

import java.util.ArrayList;
import java.util.List;

public interface ReportDAO {
    Message createReport(Report report);
    ArrayList<Report> getAllReports();

    List<Report> getAllByPending();
}
