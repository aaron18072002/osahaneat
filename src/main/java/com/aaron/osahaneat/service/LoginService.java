package com.aaron.osahaneat.service;

import com.aaron.osahaneat.dto.UserDTO;
import com.aaron.osahaneat.entity.User;
import com.aaron.osahaneat.payload.request.SignupRequest;
import com.aaron.osahaneat.repository.UserRepository;
import com.aaron.osahaneat.service.imp.LoginServiceImp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
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

    @PersistenceContext
    private EntityManager entityManager;

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

    @Transactional
    @Override
    public boolean addUser(SignupRequest signupRequest) {
        String query = """
                INSERT INTO users (user_name, password, fullname, create_date, role_id) 
                VALUES (:un, :p, :fn,  :cd, :ri)
                """;
        try {
            this.entityManager.createNativeQuery(query)
                    .setParameter("un", signupRequest.getUserName())
                    .setParameter("p", signupRequest.getPassword())
                    .setParameter("fn", signupRequest.getFullname())
                    .setParameter("cd", LocalDateTime.now())
                    .setParameter("ri", signupRequest.getRoleId())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
