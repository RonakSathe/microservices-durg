package com.ronak.UserService.external.services;

import com.ronak.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingsById(@PathVariable("userId") String userId);

    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating);

    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId);

}
