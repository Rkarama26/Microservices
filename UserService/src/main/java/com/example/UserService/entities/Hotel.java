package com.example.UserService.entities;

public class Hotel {

    private String id;

    private String name;

    private String location;

    String about;

    public Hotel() {
    }

    // All-args constructor
    public Hotel(String id, String name, String location, String about) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.about = about;
    }

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter and Setter for about
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
