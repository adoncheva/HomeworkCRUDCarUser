package com.example.UserCar.Repositories;

import com.example.UserCar.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
