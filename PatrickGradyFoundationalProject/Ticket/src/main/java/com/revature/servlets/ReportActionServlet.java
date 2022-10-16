package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Report;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ReportService reportService = new ReportService();
        UserService userService = new UserService();

        // make sure there is a manager logged in
        HttpSession session = req.getSession(false);

        if (session != null) {
            int userId = (Integer) session.getAttribute("auth-user");
            if (!userService.getUserById(userId).getRole().equals("Manager")) {
                String resPayload = mapper.writeValueAsString("Manager must be logged in to change reports");
                res.setStatus(400);
                res.setContentType("application/json");
                res.getWriter().write(resPayload);
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
            String resPayload = mapper.writeValueAsString("This report cannot be changed");
            res.setStatus(400);
            res.setContentType("application/json");
            res.getWriter().write(resPayload);
            return;
        }
        switch(action) {
            case "approve":
                reportService.Approve(id);
                break;
            case "deny":
                reportService.Deny(id);
                break;
            default:
                String resPayload = mapper.writeValueAsString("Action must be either approve or deny");
                res.setStatus(400);
                res.setContentType("application/json");
                res.getWriter().write(resPayload);
        }
    }
}
