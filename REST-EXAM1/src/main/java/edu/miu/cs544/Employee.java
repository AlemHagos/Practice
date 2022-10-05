package edu.miu.cs544;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String givenNames;

    @Column(nullable = false)
    private String familyNames;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private double salary;

    public Employee(String givenNames, String familyNames, String jobTitle, String email, double salary) {
        this.givenNames = givenNames;
        this.familyNames = familyNames;
        this.jobTitle = jobTitle;
        this.email = email;
        this.salary = salary;
    }
}
