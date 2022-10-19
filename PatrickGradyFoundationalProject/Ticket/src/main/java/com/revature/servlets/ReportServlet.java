package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Exceptions.DescriptionCannotBeBlankError;
import com.revature.Exceptions.NonPositiveAmountError;
import com.revature.dao.ReportDAOImpl;
import com.revature.models.*;
import com.revature.services.ReportService;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ReportService reportService = new ReportService();
        List<Report> reports;
        SendInfo sendInfo;

        Map<String, String[]> params = req.getParameterMap();
        if (params.containsKey("id")) {
            int id = Integer.parseInt(params.get("id")[0]);

            if (id == 0) {
                reports = reportService.getAll();
                sendInfo = new SendInfo(200, reports);
                sendInfo.send(res);

            } else {
                Report report = reportService.getReportById(id);
                sendInfo = new SendInfo(200, report);
                sendInfo.send(res);
            }

        } else if (params.containsKey("showPending")) {
            reports = reportService.getAllByPending();
            sendInfo = new SendInfo(200, reports);
            sendInfo.send(res);

        } else if (params.containsKey("userid")) {
            int userid = Integer.parseInt(params.get("userid")[0]);
            reports = reportService.getAllByUserId(userid);

            sendInfo = new SendInfo(200, reports);
            sendInfo.send(res);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        UserService userService = new UserService();
        ReportService reportService = new ReportService();
        SendInfo sendInfo;


        // pass in the user from the session
        // is there a session?
        HttpSession session = req.getSession(false);
        if (session == null) {

            sendInfo = new SendInfo(400, "There is no logged in user.");
            sendInfo.send(res);
            return;
        }

        User user = userService.getUserById((Integer) session.getAttribute("auth-user"));
        // userid , amount, description
        HashMap<String, Object> ticket = mapper.readValue(req.getInputStream(), HashMap.class);
        int userId = user.getId();
        double amount = (Double) ticket.get("amount");
        String description = (String) ticket.get("description");
        Report report = new Report(userId, (float) amount, description);
//        res.getWriter().write(mapper.writeValueAsString(report));
        // validate info
        Message msg = null;
        Report returnedReport = null;
        try {
            returnedReport = reportService.create(report);
        } catch (NonPositiveAmountError e) {
            msg = new ErrorMessage(400, "Must have a value greater than zero");
        } catch (DescriptionCannotBeBlankError e) {
            msg = new ErrorMessage(400, "Description cannot be blank");
        }

        if (msg != null) {
            sendInfo = new SendInfo(msg.getStatus(), msg.getMessage());
            sendInfo.send(res);
            return;
        }

        sendInfo = new SendInfo(200, returnedReport);
        sendInfo.send(res);

    }
}
