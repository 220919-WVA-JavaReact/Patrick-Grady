package com.revature.servlets;

import com.revature.models.SendInfo;
import com.revature.models.User;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {
    UserService userService = new UserService();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        SendInfo sendInfo;
        Map<String, String[]> params = req.getParameterMap();
        int id = Integer.parseInt(params.get("id")[0]);

        if (id == 0) {

            List<User> employees = userService.getAll();
            if (employees.size() > 0) {
                sendInfo = new SendInfo(200, employees);
                sendInfo.send(res);
            }
        } else {
            User user = userService.getUserById(id);
            if (user != null) {
                sendInfo = new SendInfo(200, user);
                sendInfo.send(res);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        SendInfo sendInfo;
        Map<String, String[]> params = req.getParameterMap();
        if (params.containsKey("id")) {
            int id = Integer.parseInt(params.get("id")[0]);
            User user = userService.deleteEmployee(id);
            if (user != null) {
                sendInfo = new SendInfo(200, user);
                sendInfo.send(res);
            } else {
                sendInfo = new SendInfo(500, "Error deleting employee");
                sendInfo.send(res);
            }
        } else {
            sendInfo = new SendInfo(400, "No employee id sepecified");
            sendInfo.send(res);
        }
    }
}
