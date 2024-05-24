package com.ronak.UserService;

import com.netflix.discovery.converters.Auto;
import com.ronak.UserService.entities.Hotel;
import com.ronak.UserService.entities.Rating;
import com.ronak.UserService.external.services.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@Slf4j
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;
	@Test
	void contextLoads() {
	}

	@Test
	void createRating(){
		Rating rating = Rating.builder()
				.rating(10)
				.userId("q254657547245")
				.hotelId("43434")
				.feedback("Good hotel.")
				.build();
		ResponseEntity<Rating> rating1 = ratingService.createRating(rating);
		log.info(rating1.getStatusCode().toString());

	}

}
