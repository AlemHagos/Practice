package edu.miu.cs544.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Tenant {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    @JsonIgnore
    @OneToMany(mappedBy = "tenant")
    private List<Contract> contracts = new ArrayList<>();
    @OneToMany(mappedBy = "tenant",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnore
    private List<Payment>payments = new ArrayList<>();

    public Tenant(String firstName, String lastName, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

}


