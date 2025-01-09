package com.example.UserService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
public class User {

    @Id
    private String userId;
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

    // No-args constructor
    public User() {
    }

    // All-args constructor
    public User(String userId, String name, String email, String about, List<Rating> ratings) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.about = about;
        this.ratings = ratings;
    }

    // Getter and Setter for userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for about
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    // Getter and Setter for ratings
    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}
