package com.example.UserCar.Services;
import com.example.UserCar.DTOs.CarRequest;
import com.example.UserCar.DTOs.CarResponse;
import com.example.UserCar.DTOs.CarUpdateResponse;


public interface CarService {

    CarResponse saveCar(CarRequest request);

    CarResponse getCar(Long id);

    void deletedCar(Long id);

    CarUpdateResponse updatedCar(Long id, CarRequest carRequest);
}
