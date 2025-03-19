package com.example.Uppgift1RestAPI.controllers;


import com.example.Uppgift1RestAPI.models.Plant;
import com.example.Uppgift1RestAPI.models.Status;
import com.example.Uppgift1RestAPI.repositories.PlantRepository;
import com.example.Uppgift1RestAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Validated
@RestController
@RequestMapping("/api/plants")
public class PlantController {
    @Autowired
    private PlantRepository plantRepository;
    @Autowired
    private UserRepository userRepository;

    // Lägg till växt i databasen
    @PostMapping
    public ResponseEntity<Plant> createPlant(@Validated @RequestBody Plant plant) {
        if(plant.getUser() != null && !userRepository.existsById(plant.getUser().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
        }
        Plant savedPlant = plantRepository.save(plant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlant);
    }
    // Få fram alla växter
    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        List<Plant> plants = plantRepository.findAll();
        return ResponseEntity.ok(plants);
    }
    // Få fram växt via id
    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable String id) {
        Plant plant = plantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found"));
        return ResponseEntity.ok(plant);
    }
    // Ändra växt via id
    @PatchMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@Validated @PathVariable String id, @RequestBody Plant plant) {
        Plant existingPlant = plantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found"));
     return ResponseEntity.ok(plantRepository.save(existingPlant));
    }
    // Ta bort växt via id
    @DeleteMapping("/{id}")
    public ResponseEntity<Plant> deletePlant(@PathVariable String id) {
        if(!plantRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found");
        }
        plantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    // Hitta växt via user id
    @GetMapping("/users/plants/{id}")
    public ResponseEntity<List<Plant>> getPlantsByUser(@PathVariable String id) {
        List<Plant> plants = plantRepository.findByUserId(id);
        if (plants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(plants);
    }
    // Hitta växt via status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Plant>> getPlantByStatus(@PathVariable Status status) {
        List<Plant> plants = plantRepository.findByStatus(status);
        return ResponseEntity.ok(plants);
    }



}
