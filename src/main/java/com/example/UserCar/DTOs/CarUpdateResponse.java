package com.example.UserCar.DTOs;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class CarUpdateResponse extends CarResponse {



    Long userId;
    String firstName;
    String lastName;

    public CarUpdateResponse(long id, @NotBlank String brand, @NotBlank String model, @NotBlank String carVin, @NotBlank String carNumber, Long userId, String firstName, String lastName) {
        super(id, brand, model, carVin, carNumber);
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CarUpdateResponse(Long userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}




