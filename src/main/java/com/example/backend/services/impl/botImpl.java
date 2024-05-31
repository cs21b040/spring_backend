package com.example.backend.services.impl;
import org.springframework.stereotype.Service;

import com.anyascii.AnyAscii;
import com.example.backend.services.GeminiService;
import com.example.backend.services.botService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class botImpl implements botService{
    GeminiService gs;
    @Override
    public String getResponse(String msg)  {
        try {
            String response_from_gemini = gs.getResponse(msg);
            System.out.println(response_from_gemini);
            return transliterateString(response_from_gemini);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Unable to process request!! Try again later";
    }
    public String transliterateString(String msg) {
        String s = AnyAscii.transliterate(msg);
        System.out.println(s);
        return s;
    }
}
