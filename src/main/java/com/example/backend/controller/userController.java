package com.example.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.user;
import com.example.backend.services.userService;

@RestController
public class userController {
    @Autowired
    private userService us;
    @PostMapping("/addUser")
    public ResponseEntity<user> addUser(@RequestBody Map<Object, Object> body) {
        user b=us.addUser(body);
        if(b!=null){
            return ResponseEntity.ok(b);
        }
        return ResponseEntity.badRequest().body(new user());
    }
    @PostMapping("/login")
    public ResponseEntity<user> login(@RequestBody Map<Object, Object> body){
        user b=us.login(body);
        if(b!=null){
            return ResponseEntity.ok(b);
        }
        return ResponseEntity.badRequest().body(new user());
    }

}