package com.aaron.osahaneat.controller;

import com.aaron.osahaneat.dto.UserDTO;
import com.aaron.osahaneat.entity.User;

import com.aaron.osahaneat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/signin")
    public ResponseEntity<?> login() {
        List<UserDTO> userDtos = this.loginService.getAllUsers();

        return new ResponseEntity(userDtos, HttpStatus.OK);
    }

}
