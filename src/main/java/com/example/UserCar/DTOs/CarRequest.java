package com.example.UserCar.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CarRequest {


    private Long id;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    @Length(min=17)
    private String carVin;

    @NotBlank
    private String carNumber;


    private Long userId;
}
