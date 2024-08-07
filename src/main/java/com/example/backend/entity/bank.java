package com.example.backend.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "bank")
public class bank {
    @Id
    String id;
    String name;
    String phone;
    String email;
    Double deposit;
    String CountryCode;
    String accountType;
    Long accountNo;
    Long pin;
    LocalDateTime time;
    public bank(String name, String phone, String email, Double deposit, String CountryCode, String accountType,Long pin,LocalDateTime time) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.deposit = deposit;
        this.CountryCode = CountryCode;
        this.accountType = accountType;
        this.pin=pin;
        this.time=time;
    }
}
