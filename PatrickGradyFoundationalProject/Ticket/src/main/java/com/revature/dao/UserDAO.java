package com.revature.dao;

import com.revature.models.User;

public interface UserDAO {
    User createUser(User user);
    User loginUser(String uname, String password);
}
