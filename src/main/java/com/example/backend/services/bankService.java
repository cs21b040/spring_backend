package com.example.backend.services;

import java.util.Map;

import com.example.backend.entity.bank;

public interface bankService {
    bank createAccount(Map<Object,Object>mp);
    bank update(Map<Object,Object>mp);
    bank getAccount(Map<Object,Object>mp);
}


/* 
 * 
 * 
 * {
  "name":"hi",
  "accNo":"1",
  "pin":"1234"
}
 */