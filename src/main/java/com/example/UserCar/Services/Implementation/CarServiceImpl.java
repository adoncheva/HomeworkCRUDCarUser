package com.example.UserCar.Services.Implementation;
import com.example.UserCar.Convertors.CarConverter;
import com.example.UserCar.DTOs.CarRequest;
import com.example.UserCar.DTOs.CarResponse;
import com.example.UserCar.DTOs.CarUpdateResponse;
import com.example.UserCar.Entities.Car;
import com.example.UserCar.Entities.User;
import com.example.UserCar.Repositories.CarRepository;
import com.example.UserCar.Repositories.UserRepository;
import com.example.UserCar.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarConverter carConverter;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    @Autowired
    public CarServiceImpl(CarConverter carConverter, CarRepository carRepository, UserRepository userRepository) {
        this.carConverter = carConverter;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CarResponse saveCar(CarRequest request) {

        Car car = carConverter.toCar(request);
        User user = userRepository.findById(request.getUserId()).get();
        car.setUser(user);
        Car savedCar = carRepository.save(car);

        return carConverter.toCarResponse(savedCar);
    }

    @Override
    public CarResponse getCar(Long id) {
        Car car = carRepository.findById(id).orElse(new Car());
        return carConverter.toCarResponse(car);
    }

    @Override
    public void deletedCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarUpdateResponse updatedCar(Long id, CarRequest carRequest) {
        Car car = carRepository.findById(id).orElseThrow();
        if (carRequest.getBrand() != null &&!carRequest.getBrand().isBlank()) {
            car.setBrand(carRequest.getBrand());
        }
        if (carRequest.getModel() != null &&!carRequest.getModel().isBlank()) {
            car.setModel(carRequest.getModel());
        } if (carRequest.getCarVin() != null &&!carRequest.getCarVin().isBlank()) {
            car.setCarVin(carRequest.getCarVin());
        }if (carRequest.getCarNumber() != null &&!carRequest.getCarNumber().isBlank()) {
            car.setCarNumber(carRequest.getCarNumber());
        } if (carRequest.getUserId() != null && !carRequest.getUserId().toString().isBlank()) {
            User user=userRepository.findById(carRequest.getUserId()).orElseThrow();
            car.setUser(user);
        }
        return carConverter.toCarUpdateResponse(carRepository.save(car));
    }
}
