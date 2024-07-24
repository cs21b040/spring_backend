package com.example.backend.services.impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.user;
import com.example.backend.repository.UserRepository;
import com.example.backend.services.userService;
@Service
public class userImpl implements userService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public user addUser(Map<Object, Object> mp) {
        String name = (String) mp.get("name");
        String email = (String) mp.get("email");
        String password = (String) mp.get("password");
        if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
            return null;
        }
        if(userRepo.existsByEmail(email)){
            return null;
        }
        user u=new user();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        try {
            userRepo.save(u);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return u;
    }
    @Override
    public user login(Map<Object, Object> mp) {
        String email=(String) mp.get("email");
        String password=(String) mp.get("password");
        if(!email.isEmpty() && !password.isEmpty()){
            Optional<user> ou = userRepo.findByEmail(email);
            if(ou.isPresent()){
                user u=ou.get();
                if(u.getPassword().equals(password)){
                    return u;
                }
            }
        }
        return null;
    }
}
