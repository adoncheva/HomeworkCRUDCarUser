package com.example.UserCar.Convertors;

import com.example.UserCar.DTOs.UserRequest;
import com.example.UserCar.DTOs.UserResponse;
import com.example.UserCar.Entities.User;
import org.springframework.stereotype.Component;

@Component

public class UserConverter {

    public User toUser (UserRequest request){
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .pwd(request.getPwd())
                .build();
        return user;
    }

    public UserResponse toUserResponse(User user){

        UserResponse userResponse = new UserResponse(user.getId(), user.getFirstName(),
                user.getLastName(), user.getEmail(),user.getCar());
                return userResponse;
    }
}
