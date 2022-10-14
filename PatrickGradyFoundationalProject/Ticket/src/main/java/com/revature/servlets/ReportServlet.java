package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReportDAOImpl;
import com.revature.models.ErrorMessage;
import com.revature.models.Report;
import com.revature.models.User;
import com.revature.services.ReportService;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ReportServlet extends HttpServlet {

//    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        ReportService reportService = new ReportService();
//
//        Map<String, String[]> params = req.getParameterMap();
//        int id = Integer.parseInt(params.get("id")[0]);
//
//        if (id == 0) {
//            reportService.getAllReports();
//        }
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        UserService userService = new UserService();
        // pass in the user from the session
        // is there a session?
        HttpSession session = req.getSession(false);
        if (session == null) {
            ErrorMessage error = new ErrorMessage(400, "There is no logged in user.");
            res.setStatus(error.getStatus());
            res.setContentType("application/json");
            res.getWriter().write(mapper.writeValueAsString(error.getMsg()));
            return;
        }

        User user = userService.getUserById((Integer)session.getAttribute("auth-user"));
        // userid , amount, description
        HashMap<String, Object> ticket = mapper.readValue(req.getInputStream(), HashMap.class);
        int userid = user.getId();
        double amount = (Double)ticket.get("amount");
        String description = (String) ticket.get("description");
        Report report = new Report(userid, (float) amount, description);
//        res.getWriter().write(mapper.writeValueAsString(report));

    }
}
