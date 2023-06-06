package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component//bu classtan springin obje üretmesini istiyoruz.
@Scope("prototype")
public class MailService implements MessageService {

    @PostConstruct//classın constructor metodu çağrıldıktan hemen sonra bu metodu(init) çağır
    public void init(){
        System.out.println("mail servis objesi oluşuyor.");
    }

    @PreDestroy//classın objesi öldürülmesinden hemen önce bu metodu çağır
    public void destroy(){
        System.out.println("mail servis objesi sonlandırıldı.");
    }

//    @Autowired//reponun objesini classa enjekte ediyor.(DI)--->field injection
//    @Qualifier("fileRepository")
//    private Repo repo;


    //setter injection
//    private Repo repo;
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepo(Repo repo) {
//        this.repo = repo;
//    }

    //constructor injection:daha güvenli,daha anlaşılır, test etmek daha kolay
    private Repo repo;
    @Autowired
    public MailService(@Qualifier("fileRepository") Repo repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir mail servisiyim. Mesajınız:"+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //reponun metodunu için objesine ihityacımız var
        repo.save(message);
    }
}
