package com.revature.services;

import com.revature.dao.HelperDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.ErrorMessage;
import com.revature.models.User;
import com.revature.util.Helper;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    UserDAOImpl udao;

    public UserService() {
        udao = new UserDAOImpl();
    }

    public UserService(UserDAOImpl udao) {
        this.udao = udao;
    }

    public ErrorMessage create(User user) {
        // First validate the user info sent
        // first / last name should be a non-null string
        if (user.getfName().trim().equals("")){
            return new ErrorMessage(400, "First name cannot be blank.");
        }
        if (user.getlName().trim().equals("")){
            return new ErrorMessage(400, "Last name cannot be blank.");
        }
        // username should be unique
        if (HelperDAO.IsUserNameTaken(user.getuName())){
            return new ErrorMessage(400, "Username taken.");
        }
        // username cannot be blank
        if (user.getuName().trim().equals("")){
            return new ErrorMessage(400, "User name cannot be blank.");
        }
        // password cannot be blank
        if (user.getPassword().trim().equals("")){
            return new ErrorMessage(400, "Password cannot be blank.");
        }
        udao.createUser(user);
        return null;

    }

    public ErrorMessage login(String uname, String password) {

        if (uname.trim().equals("")){
            return new ErrorMessage(400, "User name cannot be blank.");
        }
        if (password.trim().equals("")){
            return new ErrorMessage(400, "Password cannot be blank.");
        }


        return null;

    }

    public void promote(User manager, User employee) {
        if (manager.getRole().equals("Employee")){
            System.out.println("Employees must be promoted by managers");
            return;
        }
        if (employee.getRole().equals("Manager")){
            System.out.println(employee.getuName() + " is already a manager");
            return;
        }
        employee.setRole("Manager");
    }

    public void demote(User manager, User employee) {
        if (manager.getRole().equals("Employee")){
            System.out.println("Employees must be promoted by managers");
            return;
        }
        if (employee.getRole().equals("Manager")){
            System.out.println(employee.getuName() + " is already a manager");
            return;
        }
        if (employee.getId() == manager.getId()){
            System.out.println("You cannot demote yourself");
        }
        employee.setRole("Employee");
    }

    public ArrayList<User> getAll(){
        return udao.getAllEmployees();
    }

    public User getUserById(int id) {
        return udao.getEmployeeById(id);
    }

    public User deleteEmployee(int id){
        return udao.deleteEmployee(id);
    }
}
