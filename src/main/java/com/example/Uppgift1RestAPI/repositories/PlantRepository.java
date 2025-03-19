package com.example.Uppgift1RestAPI.repositories;

import com.example.Uppgift1RestAPI.models.Plant;
import com.example.Uppgift1RestAPI.models.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlantRepository extends MongoRepository<Plant, String> {

    List<Plant> findByStatus(Status status);
    List<Plant> findByUserId(String userId);
}
