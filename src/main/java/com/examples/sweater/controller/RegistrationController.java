package com.examples.sweater.controller;

import com.examples.sweater.model.Role;
import com.examples.sweater.model.User;
import com.examples.sweater.repos.UserRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    private final Logger log = Logger.getLogger(RegistrationController.class);

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("message", "User <b>" + user.getUsername() + "</b> already exist");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        model.addAttribute("message", "User <b>" + user.getUsername() + "</b> add. Please login");
        return "redirect:/login";
    }

}
