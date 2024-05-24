package com.ronak.UserService.controllers;

import com.ronak.UserService.entities.User;
import com.ronak.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {



    private final UserService userService;
    //create

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //single user get


    //Just to check how much to retry
    int retryCount=1;
    //If circuit not works, we go to fallback method, where return type of this method and fallback should be same.
    @GetMapping("/{userId}")
    //@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    // name = "ratingHotelService" . THE NAME IS REFERRED FROM application.yml file
    @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback" )
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){

        log.info("Retry  Count : {}",retryCount);
        retryCount++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);

    }



    //Fallback method
    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){

        log.info("Fallback is executed because service is down: {}",ex.getMessage());
        User user=User.builder()
                .email("dummmy@gmail.com")
                .name("Dummy")
                .about("It is  dummy fallback")
                .userId("2355346")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    //all users get
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){

        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }



    //all user get

}
