package com.example.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.user;
@Repository
public interface UserRepository extends MongoRepository<user,String>{
    Optional<user> findByEmail(String email);
    boolean existsByEmail(String email);
}