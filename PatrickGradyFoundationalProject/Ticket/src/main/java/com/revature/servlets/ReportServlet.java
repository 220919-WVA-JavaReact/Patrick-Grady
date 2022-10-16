package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        List<Report> reports = null;

        Map<String, String[]> params = req.getParameterMap();
        if (params.containsKey("id")) {
            int id = Integer.parseInt(params.get("id")[0]);

            if (id == 0) {
                reports = reportService.getAll();
                String resPayload = mapper.writeValueAsString(reports);
                res.setStatus(200);
                res.setContentType("application/json");
                res.getWriter().write(resPayload);


            } else {
                Report report = reportService.getReportById(id);
                String resPayload = mapper.writeValueAsString(report);
                res.setStatus(200);
                res.setContentType("application/json");
                res.getWriter().write(resPayload);
            }
        } else if (params.containsKey("showPending")) {
            reports = reportService.getAllByPending();
            String resPayload = mapper.writeValueAsString(reports);
            res.setStatus(200);
            res.setContentType("application/json");
            res.getWriter().write(resPayload);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        UserService userService = new UserService();
        ReportService reportService = new ReportService();


        // pass in the user from the session
        // is there a session?
        HttpSession session = req.getSession(false);
        if (session == null) {
            ErrorMessage error = new ErrorMessage(400, "There is no logged in user.");
            res.setStatus(error.getStatus());
            res.setContentType("application/json");
            res.getWriter().write(mapper.writeValueAsString(error.getMessage()));
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
        Message msg = reportService.create(report);
        // persist it
        if (msg.getStatus() != 200) {
            res.setStatus(msg.getStatus());
            res.setContentType("application/json");
            res.getWriter().write(mapper.writeValueAsString(msg.getMessage()));
            return;
        }
        res.setStatus(200);
        res.setContentType("application/json");
        res.getWriter().write(mapper.writeValueAsString(msg.getPayload()));

    }
}
