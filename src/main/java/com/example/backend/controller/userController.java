package com.example.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.ResponseMsgDTO;
import com.example.backend.services.userService;

@RestController
public class userController {
    @Autowired
    private userService us;
    @PostMapping("/addUser")
    public ResponseEntity<ResponseMsgDTO> addUser(@RequestBody Map<Object, Object> body) {
        boolean b=us.addUser(body);
        if(b){
            return ResponseEntity.ok(new ResponseMsgDTO("User added successfully"));
        }
        return ResponseEntity.badRequest().body(new ResponseMsgDTO("Please fill all required Details"));
    }
    @PostMapping("/login")
    public ResponseEntity<ResponseMsgDTO> login(@RequestBody Map<Object, Object> body){
        boolean b=us.login(body);
        if(b){
            System.out.println("Hello");
            return ResponseEntity.ok(new ResponseMsgDTO("User Logged in successfully"));
        }
        return ResponseEntity.badRequest().body(new ResponseMsgDTO("Wrong user Details"));
    }

}