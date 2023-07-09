package com.example.UserCar.Repositories;

import com.example.UserCar.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
