package com.example.UserService.entities;

public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    private Hotel hotel;

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    // No-args constructor
    public Rating() {
    }

    // All-args constructor
    public Rating(String ratingId, String userId, String hotelId, int rating, String feedback, Hotel hotel) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedback = feedback;
        this.hotel = hotel;
    }

    // Getter and Setter for ratingId
    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    // Getter and Setter for userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter and Setter for hotelId
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    // Getter and Setter for rating
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // Getter and Setter for feedback
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
