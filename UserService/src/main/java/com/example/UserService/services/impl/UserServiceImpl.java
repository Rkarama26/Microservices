package com.example.UserService.services.impl;

import com.example.UserService.entities.Hotel;
import com.example.UserService.entities.Rating;
import com.example.UserService.entities.User;
import com.example.UserService.exception.ResourceNotFoundException;
import com.example.UserService.repository.UserRepository;
import com.example.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        //unique user id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            try {
                Rating[] ratingOfUser = restTemplate.getForObject(
                        "http://REVIEWSERVICE/rating/user/" + user.getUserId(), Rating[].class
                );
                List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

                List<Rating> ratingList = ratings.stream().map(rating -> {
                    //api call to hotel service
                    //http://localhost:8081/hotels/c934e1d1-f5f8-4f9e-94ea-4fd35c44623f
                    ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
                    Hotel hotel = forEntity.getBody();
                    logger.info("Status code: {}:  " + forEntity.getStatusCode());


                    //set hotel to rating
                    rating.setHotel(hotel);

                    //return the rating
                    return rating;
                }).collect(Collectors.toList());
                logger.info("rating for user {}: {}", user.getUserId(), ratings);

                user.setRatings(ratings);

            } catch (Exception e) {
                logger.error("failed to fetch ratings fo users {}: {}", user.getUserId(), e.getMessage(), e);
                user.setRatings(new ArrayList<>());
            }

        }
        return users;
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found Exception " + userId));

        Rating[] ratingOfUser = restTemplate.getForObject("http://REVIEWSERVICE/rating/user/" + userId, Rating[].class);
        logger.info("ratingOfUser: " + ratingOfUser);

        List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service
            //http://localhost:8081/hotels/c934e1d1-f5f8-4f9e-94ea-4fd35c44623f
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();
            logger.info("Status code: {}:  " + forEntity.getStatusCode());


            //set hotel to rating
            rating.setHotel(hotel);

            //return the rating
            return rating;
        }).collect(Collectors.toList());


        user.setRatings(ratingList);

        return user;
    }

    @Override
    public void deleteUser(String userId) {

        userRepository.deleteById(userId);

    }
}
