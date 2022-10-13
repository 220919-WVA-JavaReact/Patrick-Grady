package com.revature.servlets;

import com.revature.models.User;
import com.revature.services.ReportService;
import com.revature.services.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserServlet extends HttpServlet {
    UserService userService;

    public UserServlet() {
        userService = new UserService();
    }

    public UserServlet(UserService userService) {
        this.userService = userService;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();

//        res.setHeader("");
        ArrayList<User> employees = userService.getAll();
        for (User e : employees){
            out.println(e);
        }
    }
}
