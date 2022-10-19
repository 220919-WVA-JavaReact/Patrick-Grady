package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Exceptions.*;
import com.revature.models.ErrorMessage;
import com.revature.models.SendInfo;
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
import java.util.Map;

public class AuthServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserService userService = new UserService();
        ObjectMapper mapper = new ObjectMapper();
        SendInfo sendInfo;

        Map<String, String[]> params = req.getParameterMap();
        String action = params.get("action")[0];
        PrintWriter out = res.getWriter();
        switch (action) {
            case "login": {
                HashMap<String, Object> credentials = mapper.readValue(req.getInputStream(), HashMap.class);
                String username = (String) credentials.get("username");
                String password = (String) credentials.get("password");
                login(req, res, username, password);
                break;
            }
            case "register": {
                logout(req, res);
                User user;
                // create new user from info we get from the front end
                HashMap<String, Object> userInput = mapper.readValue(req.getInputStream(), HashMap.class);
                String fName = (String) userInput.get("fName");
                String lName = (String) userInput.get("lName");
                String uName = (String) userInput.get("uName");
                String password = (String) userInput.get("password");
                user = new User(fName, lName, uName, password);
                ErrorMessage error = null;
                try {
                    user = userService.create(user);
                } catch (FirstNameCannotBeBlankException e) {
                    error = new ErrorMessage(400, "First name cannot be blank.");
                } catch (LastNameCannotBeBlankException e) {
                    error = new ErrorMessage(400, "Last name cannot be blank.");
                } catch (PasswordCannotBeBlankException e) {
                    error = new ErrorMessage(400, "Password cannot be blank.");
                } catch (UsernameCannotBeBlankException e) {
                    error = new ErrorMessage(400, "User name cannot be blank.");
                } catch (UserNameCannotBeTakenException e) {
                    error = new ErrorMessage(400, "Username taken.");
                }
                // send either error message or user to the front end

                if (error != null) {
                    sendInfo = new SendInfo(400, error.getMessage());
                    sendInfo.send(res);
                    break;
                }

                login(req, res, uName, password);
                break;
            }
            case "logout":
                logout(req, res);
                break;
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse res, String username, String password) throws IOException {
        UserService userService = new UserService();
        SendInfo sendInfo;
        User user = null;

        logout(req, res);

        ErrorMessage error = null;
        try {
            user = userService.login(username, password);
        } catch (UsernameCannotBeBlankException e) {
            error = new ErrorMessage(400, "User name cannot be blank.");
        } catch (PasswordCannotBeBlankException e) {
            error = new ErrorMessage(400, "Password cannot be blank.");
        } catch (InvalidCredentials e) {
            error = new ErrorMessage(400, "Invalid Credentials");
        }

        if (error != null) {
            sendInfo = new SendInfo(error.getStatus(), error.getMessage());
            sendInfo.send(res);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("auth-user", user.getId());

        sendInfo = new SendInfo(200, "Logged in as " + user.getuName());
        sendInfo.send(res);

    }

    private void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
        UserService userService = new UserService();
        HttpSession session = req.getSession(false);

        if (session != null) {
            int id = (Integer)session.getAttribute("auth-user");
            SendInfo sendInfo = new SendInfo(200, "Logging out of " + userService.getUserById(id).getuName());
            sendInfo.send(res);

            session.invalidate();
        }
    }
}

