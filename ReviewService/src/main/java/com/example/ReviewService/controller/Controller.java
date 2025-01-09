package com.example.ReviewService.controller;
import com.example.ReviewService.entities.Rating;
import com.example.ReviewService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/rating")
public class Controller {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/")
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> getRating(){
       return ResponseEntity.ok(ratingService.getRatings());
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }








}
