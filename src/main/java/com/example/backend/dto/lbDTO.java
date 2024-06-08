package com.example.backend.dto;

import java.util.List;

import com.example.backend.entity.leaderBoard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class lbDTO {
    List<leaderBoard> lb;
    String msg;
    public lbDTO(String msg){
        this.msg=msg;
    }
}
