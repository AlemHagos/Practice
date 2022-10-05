package edu.miu.cs544.service;

import edu.miu.cs544.domain.*;

import java.util.List;

public interface RentalService {
        List<Residence> getResidences();
        Integer addHouse(House house, Address address);
         boolean deleteResidence(Integer residenceId);
         Long updateContract(Long contractId, Contract contract);
          List<Payment> underPayments(double amount);

}
