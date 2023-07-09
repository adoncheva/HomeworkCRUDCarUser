package com.example.UserCar.Services.Implementation;
import com.example.UserCar.Convertors.UserConverter;
import com.example.UserCar.DTOs.UserRequest;
import com.example.UserCar.DTOs.UserResponse;
import com.example.UserCar.Entities.User;
import com.example.UserCar.Repositories.UserRepository;
import com.example.UserCar.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserConverter userConverter;
    private final UserRepository userRepository;
    @Autowired

    public UserServiceImpl(UserConverter userConverter, UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse saveUser(UserRequest request) {
        User user = userConverter.toUser(request);
        User savedUser = userRepository.save(user);


        return userConverter.toUserResponse(savedUser);
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElse(new User());
        return userConverter.toUserResponse(user);
    }

    @Override
    public void deletedUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse updatedUser(Long id, UserRequest userRequest) {
        User user=userRepository.findById(id).orElseThrow();



        if (userRequest.getFirstName() != null &&!userRequest.getFirstName().isBlank()) {
            user.setFirstName(userRequest.getFirstName());
        }
        if ( userRequest.getLastName() != null && !userRequest.getLastName().isBlank()) {
            user.setLastName(userRequest.getLastName());
        }

        if (userRequest.getEmail() != null && !userRequest.getEmail().isBlank()) {
            user.setEmail(userRequest.getEmail());
        }if (userRequest.getPwd() != null && !userRequest.getPwd().isBlank()) {
            user.setPwd(userRequest.getPwd());
        }


        return userConverter.toUserResponse(
                userRepository.save(user));
    }
}
