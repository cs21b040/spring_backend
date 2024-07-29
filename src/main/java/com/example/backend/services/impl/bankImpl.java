package com.example.backend.services.impl;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.example.backend.repository.bankRepository;
import com.example.backend.services.bankService;
import com.example.backend.entity.bank;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class bankImpl implements bankService{
    @Autowired
    private bankRepository bankRepo;

    @Override
    public bank createAccount(Map<Object,Object>mp) {
        String name=(String)mp.get("name");
        String phone = (String)mp.get("phone");
        String mail = (String)mp.get("mail");
        String countryCode = (String)mp.get("countryCode");
        String accType = (String)mp.get("accType");
        Long pin=Long.parseLong((String)mp.get("pin"));
        Double deposit = Double.parseDouble((String) mp.get("deposit"));
        if (name == null || name.isEmpty() || phone == null || phone.isEmpty() ||
            mail == null || mail.isEmpty() || countryCode == null || countryCode.isEmpty() ||
            accType == null || accType.isEmpty() ||deposit == null || pin == null) {
            return null;
        }
        Optional<bank>userExists = bankRepo.findByEmailAndAccountType(mail, accType);
        if(userExists.isPresent()){
            return null;
        }
        else{
            try {
                LocalDateTime date = LocalDateTime.now();
                bank b=new bank(name,phone,mail,deposit,countryCode,accType,pin,date);
                long count = bankRepo.count();
                b.setAccountNo(count+1);
                bankRepo.save(b);
                return b;
            } 
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public bank getAccount(Map<Object, Object> mp) {
        Long accNo=Long.parseLong((String)mp.get("accNo"));
        Long pin=Long.parseLong((String)mp.get("pin"));
        Optional<bank>userExists = bankRepo.findByAccountNo(accNo);
        if(userExists.isPresent()){
            bank b=userExists.get();
            if(b.getPin().equals(pin)){
                return b;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }

    @Override
    public bank update(Map<Object, Object> mp) {
        Long accNo=Long.parseLong((String)mp.get("accNo"));
        Long pin=Long.parseLong((String)mp.get("pin"));
        Double deposit=Double.parseDouble((String)mp.get("deposit"));
        Optional<bank>userExists = bankRepo.findByAccountNo(accNo);
        if (userExists.isPresent()) {
            bank user = userExists.get();
            bankRepo.delete(user);
            if(!user.getPin().equals(pin)){
                return null;
            }
            user.setDeposit(deposit);
            bankRepo.save(user);
            return user;
        } else {
            return null;
        }
    }
}
