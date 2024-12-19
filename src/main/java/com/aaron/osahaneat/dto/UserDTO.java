package com.aaron.osahaneat.dto;

import com.aaron.osahaneat.entity.Role;
import com.aaron.osahaneat.entity.User;

public class UserDTO {

    private String userName;
    private String password;
    private String fullname;
    private Role role;

    private UserDTO() {

    }

    private UserDTO(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.fullname = builder.fullname;
        this.role = builder.role;
    }

    public static Builder builder() {
        return new Builder();
    }

    // chỉ có setter, vì muốn immutable object
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public Role getRole() {
        return role;
    }

    public static class Builder {
        private String userName;
        private String password;
        private String fullname;
        private Role role;

        private Builder() {

        }

        // chỉ có setter
        public Builder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withFullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder withRole(Role role) {
            this.role = role;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }

    }

}
