package com.example.backend.services.impl;
import org.springframework.stereotype.Service;

import com.example.backend.services.botService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class botImpl implements botService {@Override
    public String getResponse(String msg) {
        return "From Bot : "+msg;
    }    
}
