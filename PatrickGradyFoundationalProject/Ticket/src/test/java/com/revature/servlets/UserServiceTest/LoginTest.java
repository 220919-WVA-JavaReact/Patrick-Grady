package com.revature.servlets.UserServiceTest;

import com.revature.Exceptions.InvalidCredentials;
import com.revature.Exceptions.PasswordCannotBeBlankException;
import com.revature.Exceptions.UsernameCannotBeBlankException;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LoginTest {
    @InjectMocks
    UserService userService = new UserService();
    @Mock
    UserDAOImpl userDAO;

    @Test
    public void usernameIsBlank()  {
        String username = "";
        String password = "password";
        assertThrows(UsernameCannotBeBlankException.class, () -> userService.login(username, password));
    }

    @Test
    public void passwordIsBlank()  {
        String username = "username";
        String password = "";
        assertThrows(PasswordCannotBeBlankException.class, () -> userService.login(username, password));
    }

    @Test
    public void userLoggedIn() throws PasswordCannotBeBlankException, InvalidCredentials, UsernameCannotBeBlankException {
        String username = "patgrady";
        String password = "pass1234";
        User userDaoExpected = new User(1, "Patrick", "Grady", "patgrady", "pass1234", "Manager");
//        Mockito.when(userDAO.login(username, password)).thenReturn(userDaoExpected);
        assertEquals(userService.login(username, password), userDaoExpected);
    }
}
