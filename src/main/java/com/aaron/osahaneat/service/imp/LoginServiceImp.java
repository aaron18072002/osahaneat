package com.aaron.osahaneat.service.imp;

import com.aaron.osahaneat.dto.UserDTO;
import com.aaron.osahaneat.payload.request.SignupRequest;

import java.util.List;

public interface LoginServiceImp {

    List<UserDTO> getAllUsers();

    boolean checkLogin(String userName, String password);

    boolean addUser(SignupRequest signupRequest);

}
