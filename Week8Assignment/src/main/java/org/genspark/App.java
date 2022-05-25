package org.genspark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        // XMLConfig();

        //Java Configuration Class
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    student s = (student) context.getBean("student1");
    student s2  =(student) context.getBean("student2");
        System.out.println("student1: "+ s);
        System.out.println("student2: " + s2);
    }
    public static void XMLConfig(){
        //XML CONFIGURATION
        ApplicationContext context= new ClassPathXmlApplicationContext("demo.xml");
        student s = (student) context.getBean("Student");
        //Printing the properties of the student object
        System.out.println(s);
    }
}
