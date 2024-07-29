package com.example.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.backend.entity.bank;
import com.example.backend.services.bankService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class bankController {
    @Autowired
    private bankService bs;
    @PostMapping("/bank/create")
    public ResponseEntity<bank> create(@RequestBody Map<Object,Object>body) {
        bank b=bs.createAccount(body);
        if(b!=null) return ResponseEntity.ok(b);
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/bank/update")
    public ResponseEntity<bank> postMethodName(@RequestBody Map<Object,Object>body) {
        bank b=bs.update(body);
        if(b!=null) return ResponseEntity.ok(b);
        return ResponseEntity.badRequest().body(null);
    }
    @PostMapping("/bank/get")
    public ResponseEntity<bank> get(@RequestBody Map<Object,Object>body) {
        bank b=bs.getAccount(body);
        if(b!=null) return ResponseEntity.ok(b);
        return ResponseEntity.badRequest().body(null);
    }
    
}
