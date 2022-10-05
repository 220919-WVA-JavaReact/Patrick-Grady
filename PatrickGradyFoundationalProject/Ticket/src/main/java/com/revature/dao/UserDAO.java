package com.revature.dao;

import com.revature.models.User;

public interface UserDAO {
    public User createUser(User user);
    public User loginUser(String uname, String password);
}
