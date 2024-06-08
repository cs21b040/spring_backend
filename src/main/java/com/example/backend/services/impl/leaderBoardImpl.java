package com.example.backend.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.backend.entity.leaderBoard;
import com.example.backend.repository.LeaderBoardRepository;
import com.example.backend.services.leaderBoardService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class leaderBoardImpl implements leaderBoardService {
    @Autowired
    private LeaderBoardRepository repo;
    @Scheduled(cron = "0 0 0 * * MON") // Run every Monday at 00:00
    public void resetLeaderBoard() {
        repo.deleteAll();
    }
    @Override
    public boolean addScore(String name,String mail, int score,LocalDateTime timestamp) {
        try {
            Optional<leaderBoard> op=repo.findByMail(mail);
            if(op.isPresent()){
                leaderBoard md=op.get();
                md.setScore(score);
                md.setTimestamp(timestamp);
                repo.save(md);
                return true;
            }
            else{
                leaderBoard lb=new leaderBoard();
                lb.setName(name);
                lb.setMail(mail);
                lb.setScore(score);
                lb.setTimestamp(timestamp);
                repo.save(lb);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public List<leaderBoard> getLeaderBoard(String mail) {
        List<leaderBoard> lb=repo.findAllByOrderByScoreDesc();
        List<leaderBoard> lb1=new ArrayList<>();
        for(int i=0;i<Math.min(10,lb.size());i++){
            lb1.add(lb.get(i));
        }
        for(int i=0;i<lb.size();i++){
            if(i<10 && lb.get(i).getMail().equals(mail)){
                lb1.get(i).setName("You");
                return lb1;
            }
            if(lb.get(i).getMail().equals(mail)){
                lb1.add(new leaderBoard(i,"You-1"));
                return lb1;
            }
        }
        return lb1;
    }
}
