package com.revature.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    ObjectMapper mapper = new ObjectMapper();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        PrintWriter out = res.getWriter();
        Map<String, String[]> params = req.getParameterMap();
        int id = Integer.parseInt(params.get("id")[0]);

        if (id == 0) {

            List<User> employees = userService.getAll();
            if (employees.size() > 0) {
                String resPayload = mapper.writeValueAsString(employees);
                res.setContentType("application/json");
                res.getWriter().write(resPayload);
            }
        } else {
            User user = userService.getUserById(id);
            if (user != null) {
                String resPayload = mapper.writeValueAsString(user);
                res.setContentType("application/json");
                res.getWriter().write(resPayload);
            }
        }
    }
}
