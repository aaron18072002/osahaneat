package com.aaron.osahaneat.controller;

import com.aaron.osahaneat.payload.ResponseData;
import com.aaron.osahaneat.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private FileServiceImp fileService;

    @PostMapping("/create")
    public ResponseEntity<?> createRestaurant(@RequestBody MultipartFile file) {
        ResponseData responseData = new ResponseData();

        boolean isSucess = fileService.saveFile(file);
        responseData.setSuccess(isSucess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
