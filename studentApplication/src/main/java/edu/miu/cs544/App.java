package edu.miu.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        Student s1=new Student(" Alex Salmon","alex@gmail.com",4.0);
        Student s2=new Student(" James Jackson","james@gmail.com",3.86);
        Student s3=new Student(" Anna Smith","anna@gmail.com",3.88);
        Student s4=new Student(" Marta Sanders","marta@gmail.com",3.68);
        Student[] students={s1,s2,s3,s4};
        for (Student s:students){
            studentService.addStudent(s);
        }
    }
}
