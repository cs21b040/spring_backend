package com.example.backend.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "bank")
public class bank {
    String name;
    String phone;
    String email;
    Double deposit;
    String CountryCode;
    String accountType;
    Long AccountNo;
    public bank(String name, String phone, String email, Double deposit, String CountryCode, String accountType) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.deposit = deposit;
        this.CountryCode = CountryCode;
        this.accountType = accountType;
    }
}
