package com.ronak.UserService.services.impl;

import com.ronak.UserService.entities.Hotel;
import com.ronak.UserService.entities.Rating;
import com.ronak.UserService.entities.User;
import com.ronak.UserService.exceptions.ResourceNotFoundException;
import com.ronak.UserService.external.services.HotelService;
import com.ronak.UserService.external.services.RatingService;
import com.ronak.UserService.repositories.UserRepository;
import com.ronak.UserService.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    private HotelService hotelService;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //Get all users
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<User> getAllUser() {
        List<User> all = userRepository.findAll();
        all.forEach(one -> one.setRatings(ratingService.getRatingsById(one.getUserId())));
        return all;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // //////////////   //////////////  GET USER BY userId //////////////////  ///////////////  ///////
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User with given id not found: " + userId));

        ///USING OPEN FEIGN CLIENT
        List<Rating> ratings = ratingService.getRatingsById(userId);
        List<Rating> ratingList = ratings.stream().map(rating -> {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            //set the hotel to rating
            rating.setHotel(hotel);
            log.info(hotel.toString());
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
