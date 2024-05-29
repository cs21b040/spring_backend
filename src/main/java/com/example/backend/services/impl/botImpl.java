package com.example.backend.services.impl;
import org.springframework.stereotype.Service;

import com.anyascii.AnyAscii;
import com.example.backend.services.botService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class botImpl implements botService {
    @Override
    public String getResponse(String msg) {
        return "From Bot : "+transliterateString(msg);
    }
    public String transliterateString(String msg) {
        String s = AnyAscii.transliterate(msg);
        System.out.println(s);
        return s;
    }
}
