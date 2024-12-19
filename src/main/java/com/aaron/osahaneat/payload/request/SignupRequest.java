package com.aaron.osahaneat.payload.request;

public class SignupRequest {

    private String fullname;
    private String password;
    private String userName;
    private int roleId;

    public SignupRequest() {

    }

    public SignupRequest(String fullname, String password, String userName, int roleId) {
        this.fullname = fullname;
        this.password = password;
        this.userName = userName;
        this.roleId = roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
