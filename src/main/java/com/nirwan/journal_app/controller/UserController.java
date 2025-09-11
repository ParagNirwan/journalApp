package com.nirwan.journal_app.controller;


import com.nirwan.journal_app.entity.User;
import com.nirwan.journal_app.repository.UserRepository;
import com.nirwan.journal_app.service.UserService;
import com.nirwan.journal_app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

    @GetMapping("all-users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }


    @GetMapping
    public ResponseEntity<String> greetings() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>("Hi " + authentication.getName() + ", Weather: " + weatherService.getWeather("Bhopal").getCurrent().getTemperature(), HttpStatus.OK);
    }



    // This Works
    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User userInDB = userService.findByUsername(authentication.getName());

        if (userInDB != null) {
            userInDB.setUsername(user.getUsername());
            userInDB.setPassword(user.getPassword());
        }
        userService.updateUser(userInDB);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUsername(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
