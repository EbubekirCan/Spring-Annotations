package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class MyApplication {
    public static void main(String[] args) {

        Message message=new Message();
        message.setMessage("Spring ile uygulama geliştirmek HARİKA:)");

        //config classını oku
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
        //config classındaki component scan ile tüm componentleri tarayacak
        //her component tan bir tane bean oluştur, contexte hazırda bekletecek
        //bean istediğimizde içerisindeki gerekli bağımlılıkları enjekte ederek verir


       // MessageService service=context.getBean(MailService.class);
      //  MessageService service=context.getBean(MessageService.class);//Spring akıllı
        //service.sendMessage(message);//newleme yapmadık
                                     //spring container dan rica ettik, bize hazır getirdi. IoC

       // MessageService service=context.getBean(SmsService.class);
//        MessageService service=context.getBean("smsservice",MessageService.class);
//        service.sendMessage(message);

        //interface i implemente eden  birden fazla component ile işaretlenmiş class varsa
        //hangisini alması gerektiğini belirtmemiz gerekir.

//        MessageService service=context.getBean(MailService.class);//mailservice newlenmeden geldi.
//        service.sendMessage(message);
//        service.saveMessage(message);//dbrepoyu da newlemedik.
//        //enjekte edilecek obje seçeneği birden fazla qualifier ile belirtilmeli
//
//        //Random random=new Random();-->Spring bizim için oluştursun.
//        Random random=context.getBean(Random.class);
//        System.out.println(random.nextInt(100));

        MessageService service1=context.getBean(MailService.class);
        MessageService service2=context.getBean(MailService.class);

        //spring te beanlerin default scope:singleton
        //singleton:tüm uygulama için sadece tek bir bean oluşturulur, beanin tüm life cycleından Spring sorumludur.
        //prototype:her obje istendiğinde yeni bir bean oluşturulur, beanin destroy/sonlandırılmasından sorumlu değildir.

        if(service1==service2){
            System.out.println("Aynı referanslı objeler");
            System.out.println(service1);
            System.out.println(service2);
        }else{
            System.out.println("Farklı referanslı objeler");
            System.out.println(service1);
            System.out.println(service2);
        }

        SmsService service3=context.getBean(SmsService.class);
        service3.sendMessage(message);
        service3.printContact();//value ile uyg dışından değerleri aldık
        service3.printProperties();



        //tüm uygulamadaki beanlerin isimleri
//        String[] beanNames=context.getBeanDefinitionNames();
//        for (String name:beanNames) {
//            System.out.println(name);
//        }



        context.close();//contextten obje isteyemeyiz,beanler sonlandırılır, getBean ile bean talep edemeyiz.

        System.out.println("context in close metodun sonra");


    }
}
