package com.example.UserCar.Controllers;

import com.example.UserCar.DTOs.UserRequest;
import com.example.UserCar.DTOs.UserResponse;
import com.example.UserCar.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path="/register")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserRequest request){

      UserResponse userResponse =  userService.saveUser(request);
      String response = String.format("User with name %s %s was created with %s id",
              userResponse.getFirstName(), userResponse.getLastName(),userResponse.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById (@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.FOUND).body(userService.getUser(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletedUser(@PathVariable Long id){
        userService.deletedUser(id);
        String response = String.format("User was deleted with %s id",id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
    @PutMapping(path="/update/{id}")
    public ResponseEntity<UserResponse> updatedUser(@PathVariable Long id, @RequestBody UserRequest userRequest ){

        UserResponse userResponse=userService.updatedUser(id,userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
