package com.revature.servlets.UserServiceTest;

import com.revature.Exceptions.*;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RegisterTest {

    @InjectMocks
    UserService sut = new UserService();
    @Mock
    UserDAOImpl userDAO;

    @Test
    public void firstNameIsBlank() throws FirstNameCannotBeBlankException {
        User user = new User("", "lname", "uname", "password");
        assertThrows(FirstNameCannotBeBlankException.class, () -> {sut.create(user);});
    }

    @Test
    public void lastNameIsBlank() throws LastNameCannotBeBlankException {
        User user = new User("fName", "", "uname", "password");
        assertThrows(LastNameCannotBeBlankException.class, () -> {sut.create(user);});
    }

    @Test
    public void userNameIsBlank() throws UsernameCannotBeBlankException {
        User user = new User("fName", "lName", "", "password");
        assertThrows(UsernameCannotBeBlankException.class, () -> {sut.create(user);});
    }

    @Test
    public void passwordIsBlank() throws PasswordCannotBeBlankException {
        User user = new User("fName", "lName", "uName", "");
        assertThrows(PasswordCannotBeBlankException.class, () -> {sut.create(user);});
    }

    @Test
    public void userIsValid() throws FirstNameCannotBeBlankException, LastNameCannotBeBlankException, PasswordCannotBeBlankException, UsernameCannotBeBlankException, UsernameCannotBeTakenException {
        User user = new User("fName", "lname", "uname", "password");
        User userDaoExpected = new User(1, "fName", "lname", "uname", "password", "employee");
        Mockito.when(userDAO.createUser(user)).thenReturn(userDaoExpected);
        assertEquals(sut.create(user), userDaoExpected);
    }


}
