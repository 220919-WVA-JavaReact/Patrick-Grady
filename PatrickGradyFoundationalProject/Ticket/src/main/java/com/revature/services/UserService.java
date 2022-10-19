package com.revature.services;

import com.revature.Exceptions.*;
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

    public User create(User user) throws FirstNameCannotBeBlankException, LastNameCannotBeBlankException, UserNameCannotBeTakenException, PasswordCannotBeBlankException, UsernameCannotBeBlankException {
        // First validate the user info sent
        // first / last name should be a non-null string
        if (user.getfName().trim().equals("")){
            throw new FirstNameCannotBeBlankException();
        }
        if (user.getlName().trim().equals("")){
            throw new LastNameCannotBeBlankException();
        }
        // username should be unique
        if (HelperDAO.IsUserNameTaken(user.getuName())){
            throw new UserNameCannotBeTakenException();
        }
        // username cannot be blank
        if (user.getuName().trim().equals("")){
            throw new UsernameCannotBeBlankException();
        }
        // password cannot be blank
        if (user.getPassword().trim().equals("")){
            throw new PasswordCannotBeBlankException();
        }
        return udao.createUser(user);

    }

    public User login(String uname, String password) throws UsernameCannotBeBlankException, PasswordCannotBeBlankException, InvalidCredentials {
        UserDAOImpl userDAO = new UserDAOImpl();
        if (uname.trim().equals("")){
            throw new UsernameCannotBeBlankException();
        }
        if (password.trim().equals("")){
            throw new PasswordCannotBeBlankException();
        }
        User user = userDAO.login(uname, password);
        if (user == null){
            throw new InvalidCredentials();
        }
        return user;
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
