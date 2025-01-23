package com.example.Uppgift1RestAPI.repositories;

import com.example.Uppgift1RestAPI.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
