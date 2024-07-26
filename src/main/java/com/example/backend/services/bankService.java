package com.example.backend.services;

import java.util.Map;

import com.example.backend.entity.bank;

public interface bankService {
    bank createAccount(Map<Object,Object>mp);
    // bank update(Map<Object,Object>mp);
}
