package edu.miu.cs544.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "stop")
    private Date end;
    private double amount;
    private boolean active;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tenant tenant;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Residence residence;

    public Contract(Date start, Date end, double amount, boolean active) {
        this.start = start;
        this.end = end;
        this.amount = amount;
        this.active = active;
    }
}