package com.example.SchoolProject.controller;

import com.example.SchoolProject.entity.User;
import com.example.SchoolProject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/new/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> checkValidUser(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.checkValidUser(user));
    }
}
