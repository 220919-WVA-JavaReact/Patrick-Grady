package com.revature.servlets;

import com.revature.models.Report;
import com.revature.models.SendInfo;
import com.revature.services.ReportService;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class ReportActionServlet extends HttpServlet {
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ReportService reportService = new ReportService();
        UserService userService = new UserService();
        SendInfo sendInfo;

        // make sure there is a manager logged in
        HttpSession session = req.getSession(false);

        if (session != null) {
            int userId = (Integer) session.getAttribute("auth-user");
            if (!userService.getUserById(userId).getRole().equals("Manager")) {
                sendInfo = new SendInfo(400, "Manager must be logged in to change reports");
                sendInfo.send(res);
                return;
            }
        }

        Map<String, String[]> params = req.getParameterMap();
        String action = params.get("action")[0];
        int id = Integer.parseInt(params.get("id")[0]);

        // get the report from  the id
        Report report = reportService.getReportById(id);
        // if report is already changed, can't change it again
        if (!report.getStatus().equals("Pending")) {

            sendInfo = new SendInfo(400, "This report cannot be changed");
            sendInfo.send(res);
            return;
        }
        switch(action) {
            case "approve":
                report = reportService.Approve(id);
                sendInfo = new SendInfo(200, report);
                sendInfo.send(res);
                break;
            case "deny":
                report = reportService.Deny(id);
                sendInfo = new SendInfo(200, report);
                sendInfo.send(res);
                break;
            default:
                sendInfo = new SendInfo(400, "Action must be either approve or deny");
                sendInfo.send(res);
        }
    }
}
