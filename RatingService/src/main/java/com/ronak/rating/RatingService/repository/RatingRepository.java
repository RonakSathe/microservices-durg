package com.ronak.rating.RatingService.repository;


import com.ronak.rating.RatingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating,String> {

    //custom find methods
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
