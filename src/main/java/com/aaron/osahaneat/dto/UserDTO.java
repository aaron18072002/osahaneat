package com.aaron.osahaneat.dto;

import com.aaron.osahaneat.entity.Role;
import com.aaron.osahaneat.entity.User;

public class UserDTO {

    private String userName;
    private String password;
    private String fullname;
    private Role role;

    public UserDTO() {

    }

    public UserDTO(User user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.fullname = user.getFullname();
        this.role = user.getRole();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
