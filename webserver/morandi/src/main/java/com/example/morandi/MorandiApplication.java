package com.example.morandi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MorandiApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MorandiApplication.class, args);
        Object aSd = applicationContext.getBean("adminMapper");
        System.out.println(aSd);

    }

}
