package com.aaron.osahaneat.service;

import com.aaron.osahaneat.dto.UserDTO;
import com.aaron.osahaneat.entity.Role;
import com.aaron.osahaneat.entity.User;
import com.aaron.osahaneat.payload.request.SignupRequest;
import com.aaron.osahaneat.repository.UserRepository;
import com.aaron.osahaneat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImp {

    @Autowired
    //@Qualifier("")
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDTO> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(new UserDTO.Builder()
                    .withFullname(user.getFullname())
                    .withUserName(user.getUserName())
                    .withPassword(user.getPassword())
                    .withRole(user.getRole())
                    .build());
        }
        return userDtos;
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        List<User> users = this.userRepository.findByUsernameAndPassword(userName, password);
        return users.size() > 0;
    }

    @Override
    public boolean addUser(SignupRequest signupRequest) {
        Role role = new Role();
        role.setRoleId(signupRequest.getRoleId());

        User user = new User();
        user.setFullname(signupRequest.getFullname());
        user.setPassword(signupRequest.getPassword());
        user.setUserName(signupRequest.getUserName());
        user.setRole(role);
        user.setCreateDate(LocalDateTime.now());

        try {
            this.userRepository.save(user); // INSERT INTO
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
