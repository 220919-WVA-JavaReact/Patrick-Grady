package com.revature.dao;

import com.revature.models.Message;
import com.revature.models.Report;
import java.util.List;

public interface ReportDAO {
    Message createReport(Report report);
    List<Report> getAllReports();

    List<Report> getAllByPending();
    Report getReportById(int id);

    public Report ApproveReport(int id);
    public Report DenyReport(int id);
}
