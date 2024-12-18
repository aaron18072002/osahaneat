package com.aaron.osahaneat.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name", columnDefinition = "VARCHAR(50) NOT NULL")
    private String userName;

    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "fullname", columnDefinition = "VARCHAR(50)")
    private String fullname;

    @Column(name = "create_date", columnDefinition = "DATETIME")
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_user_role"))
    private Role role;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
