package com.example.demo.repository;

import com.example.demo.model.WaterIntake;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaterIntakeRepository extends JpaRepository<WaterIntake, Long> 
{

    List<WaterIntake> findByUserId(Long userId);
}
