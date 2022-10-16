package com.revature.dao;

import com.revature.models.Message;
import com.revature.models.Report;
import java.util.List;

public interface ReportDAO {
    Message createReport(Report report);
    List<Report> getAllReports();

    List<Report> getAllByPending();
    List<Report> getReportById(int id);
}
