package com.tpe.repository;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class FileRepository implements Repo{
    @Override
    public void save(Message message) {
        System.out.println("Mesajınız dosyaya kaydediliyor. Mesajınız : "+message.getMessage());
    }
}
