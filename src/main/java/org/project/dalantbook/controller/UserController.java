package org.project.dalantbook.controller;

import org.project.dalantbook.controller.dto.request.UserRequest;
import org.project.dalantbook.domain.UserEntity;
import org.project.dalantbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequest user) {
        if (userService.findByUsername(user.getUserName()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }
}
