package com.example.backend.repository;

import com.example.backend.entity.leaderBoard;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LeaderBoardRepository extends MongoRepository<leaderBoard, String> {
    List<leaderBoard> findAllByOrderByScoreDesc();
    Optional<leaderBoard> findByMail(String mail);
}