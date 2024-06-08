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
            leaderBoard lb=new leaderBoard();
            lb.setName(name);
            lb.setMail(mail);
            lb.setScore(score);
            lb.setTimestamp(timestamp);
            System.out.println(lb.getName()+" "+lb.getScore()+" "+lb.getTimestamp()+" "+lb.getMail());
            repo.save(lb);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean updateScore(String mail, int score) {
        try {
            Optional<leaderBoard> lb=repo.findByMail(mail);
            if(lb.isPresent()){
                leaderBoard md=lb.get();
                md.setScore(score);
                repo.save(md);
                return true;
            }
            return false;

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
                lb1.add(new leaderBoard(i));
                return lb1;
            }
        }
        return lb1;
    }
}
