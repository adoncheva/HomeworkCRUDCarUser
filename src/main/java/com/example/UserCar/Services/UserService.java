package com.example.UserCar.Services;
import com.example.UserCar.DTOs.UserRequest;
import com.example.UserCar.DTOs.UserResponse;

public interface UserService {
    UserResponse saveUser(UserRequest request);

    UserResponse getUser(Long id);

    void deletedUser(Long id);

    UserResponse updatedUser(Long id, UserRequest userRequest);
}
