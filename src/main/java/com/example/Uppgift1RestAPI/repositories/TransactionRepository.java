package com.example.Uppgift1RestAPI.repositories;

import com.example.Uppgift1RestAPI.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByUserId (String userId);
}
