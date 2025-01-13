package com.smartsamagri.controller;

import com.smartsamagri.model.User;
import com.smartsamagri.service.UserService;
import com.smartsamagri.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserWebController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "Signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user) {
        user.setPassword(user.getPlainPassword()); // Hash the password before saving
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/signin")
    public String showSigninForm(Model model) {
        model.addAttribute("user", new User());
        return "Signin";
    }

    @PostMapping("/signin")
    public String signinUser(@ModelAttribute User user, Model model) {
        User existingUser = userService.getUserByEmail(user.getEmail());        

        if (existingUser == null) {
            model.addAttribute("error", "Invalid email");
            return "Signin";
        }
        if (!PasswordUtil.checkPassword(user.getPlainPassword(), existingUser.getPasswordHash())) {
            model.addAttribute("error", "Invalid password");
            return "Signin";
        }
        return "redirect:/users";
    }

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "listUsers";
    }
}