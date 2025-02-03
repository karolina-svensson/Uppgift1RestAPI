package com.example.Uppgift1RestAPI.controllers;


import com.example.Uppgift1RestAPI.models.Plant;
import com.example.Uppgift1RestAPI.repositories.PlantRepository;
import com.example.Uppgift1RestAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {
    @Autowired
    private PlantRepository plantRepository;
    @Autowired
    private UserRepository userRepository;

    // Lägg till växt i databasen
    @PostMapping
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) {
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
    // Ändra växtstatus via id
    @PatchMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable String id, @RequestBody Plant plant) {
        Plant existingPlant = plantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plant not found"));
        existingPlant.setStatus(plant.getStatus());
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
    // Denna verkar inte funka i min Postman API...
    @GetMapping("/status")
    public ResponseEntity<List<Plant>> getPlantStatus (@RequestParam String status) {
        List<Plant> plants = plantRepository.findByStatus("tillgänglig");
        return ResponseEntity.ok(plants);
    }


}
