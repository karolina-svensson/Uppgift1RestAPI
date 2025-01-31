package com.example.Uppgift1RestAPI.repositories;

import com.example.Uppgift1RestAPI.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
