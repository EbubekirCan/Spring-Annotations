package com.tpe.repository;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class DbRepository implements Repo{
    @Override
    public void save(Message message) {
        System.out.println("Mesajınız DB ye kaydediliyor. Mesajınız : "+message.getMessage());
    }
}
