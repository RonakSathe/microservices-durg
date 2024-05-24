package com.ronak.UserService.services;

import com.ronak.UserService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);




}
