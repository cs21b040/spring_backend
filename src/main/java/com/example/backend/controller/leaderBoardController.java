package com.example.backend.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.ResponseMsgDTO;
import com.example.backend.dto.lbDTO;
import com.example.backend.services.leaderBoardService;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/lb")
public class leaderBoardController {
    @Autowired
    private leaderBoardService lbs;
    @PostMapping("/addScore")
    public ResponseEntity<ResponseMsgDTO> addScore(@RequestBody Map<String, String> body) {
        String name=body.get("name");
        String mail=body.get("mail");
        int score=Integer.parseInt(body.get("score"));
        LocalDateTime timestamp=LocalDateTime.now();

        if(name.isEmpty() || mail.isEmpty() || body.get("score").isEmpty()){
            return ResponseEntity.badRequest().body(new ResponseMsgDTO("Invalid input"));
        }
        else{
            System.out.println(mail+" "+name+" "+score+" "+timestamp);
            boolean res=lbs.addScore(name, mail, score, timestamp);
            if(res){
                return ResponseEntity.ok().body(new ResponseMsgDTO("Score added successfully"));
            }
            return ResponseEntity.badRequest().body(new ResponseMsgDTO("Failed to add score"));
        }
    }
    @PutMapping("/updateScore")
    public ResponseEntity<ResponseMsgDTO> updateScore(@RequestBody Map<String, String> body) {
        String mail=body.get("mail");
        int score=Integer.parseInt(body.get("score"));
        if(mail.isEmpty() || body.get("score").isEmpty()){
            return ResponseEntity.badRequest().body(new ResponseMsgDTO("Invalid input"));
        }
        else{
            boolean res=lbs.updateScore(mail, score);
            if(res){
                return ResponseEntity.ok().body(new ResponseMsgDTO("Score updated successfully"));
            }
            return ResponseEntity.badRequest().body(new ResponseMsgDTO("Failed to update score"));
        }
    }
    @PostMapping("/getLeaderBoard")
    public ResponseEntity<lbDTO> getLeaderBoard(@RequestBody Map<String, String> body) {
        String mail=body.get("mail");
        if(mail.isEmpty()){
            return ResponseEntity.badRequest().body(new lbDTO("Invalid input"));
        }
        else{
            return ResponseEntity.ok().body(new lbDTO(lbs.getLeaderBoard(mail),"success"));
        }
    }
}