package edu.miu.cs544.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class House extends Residence {
    private int lotSize;

    public House(Date built, int squareFt, int lotSize) {
        super(built, squareFt);
        this.lotSize = lotSize;
    }
}
