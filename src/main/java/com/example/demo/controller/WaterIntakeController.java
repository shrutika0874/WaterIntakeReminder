package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.WaterIntake;
import com.example.demo.service.WaterIntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class WaterIntakeController {

    @Autowired
    private WaterIntakeService service;

    // 1. Create new User
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    // 2. Update Daily Target
    @PutMapping("/{id}/target")
    public User updateTarget(@PathVariable Long id, @RequestParam Integer target) {
        return service.updateDailyTarget(id, target);
    }

    // 3. Add Water Intake
    @PostMapping("/{id}/intake")
    public WaterIntake addIntake(@PathVariable Long id, @RequestParam Integer amount) {
        return service.addIntake(id, amount);
    }

    // 4. Get Today's Intakes
    @GetMapping("/{id}/today")
    public List<WaterIntake> getTodayIntakes(@PathVariable Long id) {
        return service.getTodayIntakes(id);
    }
}
