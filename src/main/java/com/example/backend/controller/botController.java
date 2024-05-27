package com.example.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.ResponseMsgDTO;
import com.example.backend.services.botService;

import lombok.AllArgsConstructor;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/bot")
@AllArgsConstructor
public class botController {
    private final botService bs;
    @PostMapping("/response")
    ResponseEntity<ResponseMsgDTO> getResponse(@RequestBody Map<String,String> body){
        String msg = body.get("msg");
        ResponseMsgDTO rm=new ResponseMsgDTO(bs.getResponse(msg));
        return ResponseEntity.ok(rm);
    }
}
