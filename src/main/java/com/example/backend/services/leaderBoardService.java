package com.example.backend.services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.backend.entity.leaderBoard;

public interface leaderBoardService {
    public boolean addScore(String name,String mail, int score,LocalDateTime timestamp);
    public boolean updateScore(String mail, int score);
    public List<leaderBoard> getLeaderBoard(String mail);
}
