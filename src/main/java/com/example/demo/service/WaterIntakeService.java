package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.WaterIntake;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WaterIntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WaterIntakeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WaterIntakeRepository waterIntakeRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Update the daily water intake target for a user
    public User updateDailyTarget(Long userId, Integer target) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setDailyTarget(target);
        return userRepository.save(user);
    }

    // Add a new water intake record for a user
    public WaterIntake addIntake(Long userId, Integer amount) {
        WaterIntake intake = new WaterIntake();
        intake.setUserId(userId);
        intake.setIntakeAmount(amount);
        intake.setTimestamp(LocalDateTime.now());
        return waterIntakeRepository.save(intake);
    }

    // Get today's water intake records for a specific user
    public List<WaterIntake> getTodayIntakes(Long userId) {
        return waterIntakeRepository.findByUserId(userId);
    }
}
