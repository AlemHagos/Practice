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
    private EmployeeServiceImpl employeeServiceImpl;

    @Override
    public void run(String... args) throws Exception {
        Employee emp1 = new Employee("Alex","Salmon","Engineer","alex@gmail.com",80000);
        Employee emp2 = new Employee("James","Jackson","Manager","james@gmail.com",100000);
        Employee emp3 = new Employee("Anna","Smith","Doctor","anna@gmail.com",200000);
        Employee emp4 = new Employee("Marta","Sanders","Teacher","marta@gmail.com",120000);
        Employee [] employees = {emp1, emp2, emp3, emp4};
        for (Employee  emp:employees){
            employeeServiceImpl.addNewEmployee(emp);

        }
    }
}
