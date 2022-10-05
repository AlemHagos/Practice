package edu.miu.cs544.domain;

import edu.miu.cs544.domain.Residence;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Apartment extends Residence {
    private int floor;

    public Apartment(Date built, int squareFt, int floor) {
        super(built, squareFt);
        this.floor = floor;
    }
}
