package edu.miu.cs544.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Residence {
    @Id
    @GeneratedValue
    private Integer id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date built;
    private int squareFt;
    @JsonIgnore
    @OneToMany(mappedBy = "residence")
    private List<Contract> contracts = new ArrayList<>();
    @Embedded
    private Address address;

    public Residence(Date built, int squareFt) {
        this.built = built;
        this.squareFt = squareFt;
    }
}
