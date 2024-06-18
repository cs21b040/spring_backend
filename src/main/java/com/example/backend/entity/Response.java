package com.example.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "response")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    @Id
    private String id;
    private String question;
    private String answer;
}