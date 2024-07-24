package com.example.backend.services;

import java.util.Map;

import com.example.backend.entity.user;

public interface userService {

    public user addUser(Map<Object,Object>mp);
    public user login(Map<Object,Object>mp);
}