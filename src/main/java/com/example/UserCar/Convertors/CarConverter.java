package com.example.UserCar.Convertors;

import com.example.UserCar.DTOs.CarRequest;
import com.example.UserCar.DTOs.CarResponse;
import com.example.UserCar.DTOs.CarUpdateResponse;
import com.example.UserCar.Entities.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    public Car toCar (CarRequest request){


        return Car.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .carVin(request.getCarVin())
                .carNumber(request.getCarNumber())
                .build();
    }

    public CarResponse toCarResponse(Car car){

        return new CarResponse(car.getId(), car.getBrand(),
                car.getModel(), car.getCarVin(), car.getCarNumber());
    }
    public CarUpdateResponse toCarUpdateResponse(Car car){

        CarUpdateResponse carResponse = new CarUpdateResponse(car.getId(), car.getBrand(),
                car.getModel(), car.getCarVin(), car.getCarNumber(),car.getUser().getId(),car.getUser().getFirstName(),car.getUser().getLastName());
        return carResponse;
    }

}
