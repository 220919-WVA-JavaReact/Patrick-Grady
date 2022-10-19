//package com.revature.servlets;
//
//import com.revature.Exceptions.*;
//import com.revature.dao.UserDAOImpl;
//import com.revature.models.User;
//import com.revature.services.UserService;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@Disabled
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    @InjectMocks
//    UserService sut = new UserService();
//    @Mock
//    UserDAOImpl userDAO;
//
//    @Test
//    public void createfNameIsBlank() throws FirstNameCannotBeBlankException {
//        User user = new User("", "lname", "uname", "password");
//        assertThrows(FirstNameCannotBeBlankException.class, () -> {sut.create(user);});
////        assertEquals(sut.create(user), new ErrorMessage(400, "First name cannot be blank."));
//    }
//
//    @Test
//    public void userIsValid() throws FirstNameCannotBeBlankException, LastNameCannotBeBlankException, PasswordCannotBeBlankException, UsernameCannotBeBlankException, UserNameCannotBeTakenException {
//        User user = new User("fName", "lname", "uname", "password");
//        User usrerDaoExpected = new User(1, "fName", "lname", "uname", "password", "employee");
//        Mockito.when(userDAO.createUser(user)).thenReturn(usrerDaoExpected);
//        assertEquals(sut.create(user), usrerDaoExpected);
//    }
//
//
//}
