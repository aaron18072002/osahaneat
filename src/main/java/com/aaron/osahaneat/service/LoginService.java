package com.aaron.osahaneat.service;

import com.aaron.osahaneat.dto.UserDTO;
import com.aaron.osahaneat.entity.User;
import com.aaron.osahaneat.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserInterface userInterface;

    public List<UserDTO> getAllUsers() {
        List<User> users = this.userInterface.findAll();
        List<UserDTO> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(new UserDTO(user));
            System.out.println(user);
        }
        return userDtos;
    }

}
