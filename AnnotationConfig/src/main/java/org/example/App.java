package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        student s = (student) context.getBean(student.class);
        s.setId(5);
        s.setName("Egemen");
        Address a = context.getBean(Address.class);
        a.setCity("City1");
        a.setCountry("MyCountry");
        a.setState("State1");
        a.setZipcode("11111");
        s.setAdd(a);
        System.out.println(s);

    }
}
