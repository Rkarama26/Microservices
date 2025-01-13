package com.example.UserService.external_service;

import com.example.UserService.entities.Hotel;
import com.example.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "REVIEWSERVICE")
public interface ReviewService {

    @GetMapping("/rating/user/{userId}")
    List<Rating> getRatingByUser(@PathVariable String userId);
}
