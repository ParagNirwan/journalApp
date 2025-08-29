package com.nirwan.journal_app.controller;


import com.nirwan.journal_app.entity.User;
import com.nirwan.journal_app.repository.UserRepository;
import com.nirwan.journal_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String username) {
        User userInDB = userService.findByUsername(username);

        if (userInDB != null) {
            userInDB.setUsername(user.getUsername());
            userInDB.setPassword(user.getPassword());
        }
        userService.saveUser(userInDB);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
