package com.ronak.rating.RatingService.services;

import com.ronak.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    //get all ratings
    List<Rating> getRatings();

    //all ratings by userid
    List<Rating> getRatingByUserId(String userId);

    //get all by hotel id
    List<Rating> getRatingByHotelId(String hotelId);
}
