package com.example.backend.repository;

import com.example.backend.entity.bank;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface bankRepository extends MongoRepository<bank, String> {
    Optional<bank>findByEmailAndAccountType(String email,String accountType);
    Optional<bank> findByAccountNo(Long AccountNo);
}