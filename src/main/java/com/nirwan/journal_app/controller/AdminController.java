package com.nirwan.journal_app.controller;

import com.nirwan.journal_app.entity.User;
import com.nirwan.journal_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("all-users")
    public ResponseEntity<?> getAllUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<User> all = userService.getAll();

        if (all != null) {
            List<String> names = all.stream().map(User::getUsername).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(names);
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("create-admin")
    public ResponseEntity<?> createNewAdmin(@RequestBody User user) {
        userService.saveAdmin(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
