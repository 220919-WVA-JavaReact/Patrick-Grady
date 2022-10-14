package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserService userService = new UserService();
        ObjectMapper mapper = new ObjectMapper();

        Map<String, String[]> params = req.getParameterMap();
        String action = params.get("action")[0];
        PrintWriter out = res.getWriter();
        if (action.equals("login")) {

            HashMap<String, Object> credentials = mapper.readValue(req.getInputStream(), HashMap.class);
            String username = (String) credentials.get("username");
            String password = (String) credentials.get("password");

            //get all users
            List<User> users = userService.getAll();

            for (User user : users) {
                if (username.equals(user.getuName()) && password.equals(user.getPassword())) {

                    HttpSession session = req.getSession();
                    session.setAttribute("auth-user", user.getId());

                    res.setStatus(200);
                    res.setContentType("application/json");
                    res.getWriter().write(mapper.writeValueAsString("Logged in as " + user.getuName()));
                    return;
                }

            }
            out.println("Error Logging In!");

        } else if (action.equals("register")) {
            // register
            out.println("Signing up...");

        } else if (action.equals("logout")) {
            HttpSession session = req.getSession(false);

            if (session != null) {
                int id = (Integer)session.getAttribute("auth-user");
                res.setStatus(200);
                res.setContentType("application/json");
                res.getWriter().write(mapper.writeValueAsString("Logging out " + userService.getUserById(id).getuName()));
                session.invalidate();
            }
        }
    }
}

