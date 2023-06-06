package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.Random;

@Component("smsservice")
public class    SmsService implements MessageService{

    @PostConstruct//classın constructor metodu çağrıldıktan hemen sonra bu metodu(init) çağır
    public void init(){
        System.out.println("sms servis objesi oluşuyor.");
    }

    @PreDestroy//classın objesi öldürülmesinden hemen önce bu metodu çağır
    public void destroy(){
        System.out.println("sms servis objesi sonlandırıldı.");
    }

    @Autowired
    private Random random;
    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir SMS servisiyim. Mesajınız:"+message.getMessage());
        System.out.println("random sayı :"+random.nextInt(100));
    }

    @Override
    public void saveMessage(Message message) {

    }

    //değişkenlerin değerlerini uygulamanın dışından vermek istersek
    @Value("${app.email}")
    private String email;
    @Value("${app.phone}")
    private String phone;
    public void printContact(){
//        System.out.println("email: email@email.com");
//        System.out.println("phone number: 0123456789");
        System.out.println("email: "+email+" -- phone: "+phone);
    }

    @Autowired
    private Properties properties;
    public void printProperties(){
        System.out.println("contact email :"+properties.get("mymail"));
        System.out.println("Java Home: "+properties.get("myjavahome"));
    }

}
