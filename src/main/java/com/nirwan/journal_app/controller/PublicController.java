package com.nirwan.journal_app.controller;


import com.nirwan.journal_app.entity.User;
import com.nirwan.journal_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;


    @PostMapping
    public void createNewUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
