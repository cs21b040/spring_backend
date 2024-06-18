package com.example.backend.services.impl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyascii.AnyAscii;
import com.example.backend.repository.responseRepository;
import com.example.backend.services.GeminiService;
import com.example.backend.services.botService;
import com.example.backend.entity.Response;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class botImpl implements botService{
    GeminiService gs;
    @Autowired
    responseRepository rr;
    @Override
    public String getResponse(String msg)  {
        try {
            // String response_from_gemini = gs.getResponse(msg);
            // System.out.println(response_from_gemini);
            Optional <Response> response = rr.findByQuestion(msg);
            if(response.isPresent())
                return response.get().getAnswer();
            // return transliterateString(msg);
        } catch (Exception e) {
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
