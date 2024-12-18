package com.aaron.osahaneat.controller;

import com.aaron.osahaneat.entity.User;
import com.aaron.osahaneat.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserInterface userInterface;

    @PostMapping("/signin")
    public ResponseEntity<?> login() {
        List<User> users = userInterface.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        return new ResponseEntity("", HttpStatus.OK);
    }

}
