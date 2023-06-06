package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration//bu classta config olacak
@ComponentScan("com.tpe")//bu packagedaki componentları tara, default: "com.tpe"
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Autowired
    private Environment environment;//application.properties dosyanın içindeki değişkenler ve
                                    // uygulamanın çalıştığı tüm ortam değişkenlerine ulaşmak için
                                    // Springin Environment interface i kullanılır.

    @Bean//random classından bir tane bean oluşturuluyor.
    public Random random(){
        return new Random();
    }

    //value ann ile yaptığımızı properties classı ile de yapabiliriz.
    //değişkenlerin değerlerini bir dosyadan okuyabiliriz.

    @Bean
    public Properties properties(){
        Properties properties=new Properties();
        properties.put("mymail",environment.getProperty("app.email"));
        properties.put("myjavahome",environment.getProperty("JAVA_HOME"));
        //[{email,email@email.com}]
        return properties;
    }



}
