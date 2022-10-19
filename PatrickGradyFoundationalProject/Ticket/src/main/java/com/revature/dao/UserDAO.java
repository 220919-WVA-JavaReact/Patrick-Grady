package com.revature.dao;

import com.revature.models.User;

import java.util.ArrayList;

public interface UserDAO {
    User createUser(User user);
    User login(String uname, String password);

    ArrayList<User> getAllEmployees();

    User getEmployeeById(int id);

    User deleteEmployee(int id);
}
