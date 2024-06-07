package com.example.backend.services;

import java.util.Map;

public interface userService {

    public boolean addUser(Map<Object,Object>mp);
    public boolean login(Map<Object,Object>mp);
}