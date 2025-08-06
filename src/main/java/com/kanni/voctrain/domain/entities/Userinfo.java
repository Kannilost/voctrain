package com.kanni.voctrain.domain.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "userinfo")
public class Userinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "signup_date", insertable = false, updatable = false)
    private Timestamp signupDate;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getSignupDate() {
        return signupDate;
    }

    // Getter & Setter
}