package com.aaron.osahaneat.controller;

import com.aaron.osahaneat.payload.ResponseData;
import com.aaron.osahaneat.payload.request.SignupRequest;
import com.aaron.osahaneat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    //@Qualifier("")
    private LoginServiceImp loginService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String userName, @RequestParam String password) {
        ResponseData responseData = new ResponseData();
        if(this.loginService.checkLogin(userName, password) == true) {
            responseData.setStatus(HttpStatus.OK.value());
        } else {
            responseData.setStatus(HttpStatus.UNAUTHORIZED.value());
        }

        return new ResponseEntity(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        ResponseData responseData = new ResponseData();

        responseData.setData(this.loginService.addUser(signupRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
