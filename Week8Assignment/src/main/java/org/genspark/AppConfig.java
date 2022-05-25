package org.genspark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean("student1")
    public student getstudent(){
        return new student();
    }
    @Bean("student2")
    public student getstudent2(){
        List<Phone> p = new ArrayList<Phone>(List.<Phone>of(new Phone("1234567890"), new Phone("5555555555")));
        Address a = new Address("City1","State1","MyCountry","00000");
        return new student(5,"Example",p,a);
    }
}
