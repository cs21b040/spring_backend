package com.example.backend.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "leaderBoard")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class leaderBoard {
    @Id
    private String id;
    private String name;
    private int score;
    private String mail;
    private LocalDateTime timestamp;
    public leaderBoard(int score,String temp){
        this.score = score;
        name=temp;
    }
}
