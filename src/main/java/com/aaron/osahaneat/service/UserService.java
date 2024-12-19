package com.aaron.osahaneat.service;

import com.aaron.osahaneat.dto.UserDTO;
import com.aaron.osahaneat.entity.User;
import com.aaron.osahaneat.repository.UserRepository;
import com.aaron.osahaneat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for(User user:users) {
            userDTOs.add(UserDTO.builder().withUserName(user.getUserName())
                    .withFullname(user.getFullname())
                    .withPassword(user.getPassword())
                    .withRole(user.getRole())
                    .build());
        }
        return userDTOs;
    }
}
