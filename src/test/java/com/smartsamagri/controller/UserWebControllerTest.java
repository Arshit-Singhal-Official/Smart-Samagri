package com.smartsamagri.controller;

import com.smartsamagri.model.User;
import com.smartsamagri.service.UserService;
import com.smartsamagri.util.PasswordUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserWebControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private UserWebController userWebController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowSignupForm() {
        String viewName = userWebController.showSignupForm(model);
        assertEquals("Signup", viewName);
        verify(model, times(1)).addAttribute("user", new User());
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setPlainPassword("password");

        String viewName = userWebController.createUser(user);
        assertEquals("redirect:/users", viewName);
        verify(userService, times(1)).createUser(any(User.class));
    }

    @Test
    public void testShowSigninForm() {
        String viewName = userWebController.showSigninForm(model);
        assertEquals("Signin", viewName);
        verify(model, times(1)).addAttribute("user", new User());
    }

    @Test
    public void testSigninUserWithInvalidEmail() {
        User user = new User();
        user.setEmail("invalid@example.com");
        user.setPlainPassword("password");

        when(userService.getUserByEmail(user.getEmail())).thenReturn(null);

        String viewName = userWebController.signinUser(user, model);
        assertEquals("Signin", viewName);
        verify(model, times(1)).addAttribute("error", "Invalid email");
    }

    @Test
    public void testSigninUserWithInvalidPassword() {
        User user = new User();
        user.setEmail("valid@example.com");
        user.setPlainPassword("invalidPassword");

        User existingUser = new User();
        existingUser.setPasswordHash(PasswordUtil.hashPassword("correctPassword"));

        when(userService.getUserByEmail(user.getEmail())).thenReturn(existingUser);

        String viewName = userWebController.signinUser(user, model);
        assertEquals("Signin", viewName);
        verify(model, times(1)).addAttribute("error", "Invalid password");
    }

    @Test
    public void testSigninUserWithValidCredentials() {
        User user = new User();
        user.setEmail("valid@example.com");
        user.setPlainPassword("correctPassword");

        User existingUser = new User();
        existingUser.setPasswordHash(PasswordUtil.hashPassword("correctPassword"));

        when(userService.getUserByEmail(user.getEmail())).thenReturn(existingUser);

        String viewName = userWebController.signinUser(user, model);
        assertEquals("redirect:/users", viewName);
    }

    @Test
    public void testListUsers() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userService.getAllUsers()).thenReturn(users);

        String viewName = userWebController.listUsers(model);
        assertEquals("listUsers", viewName);
        verify(model, times(1)).addAttribute("users", users);
    }
}
