package edu.miu.cs544;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Student {
    @ToString.Include
    @Id
    @GeneratedValue
    @Column(name = "student_id", nullable = false)
    private Integer studentId;
    @ToString.Include
    @Column(unique = true)
    private String email;
    @ToString.Include
    @Column(nullable = false)
    String name;
    @ToString.Include
    @Column(nullable = false)
    private double cgpa;

    public Student(String name, String email, double cgpa) {
        this.name = name;
        this.email = email;
        this.cgpa = cgpa;
    }
}
