package edu.miu.cs544.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    private double amount;
    @Temporal(TemporalType.DATE)
    private Date payDate;
    @ManyToOne
    private Tenant tenant;

    public Payment(double amount, Date payDate) {
        this.amount = amount;
        this.payDate = payDate;
    }
}
