package com.example.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Response;
@Repository
public interface responseRepository extends MongoRepository<Response,String>{
    Optional<Response> findByQuestion(String q);
}