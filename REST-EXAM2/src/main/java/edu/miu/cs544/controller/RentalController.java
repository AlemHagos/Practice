package edu.miu.cs544.controller;
import edu.miu.cs544.domain.*;
import edu.miu.cs544.service.RentalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/home")
public class RentalController {
    @Autowired
    private RentalServiceImpl rentalServiceImpl;

    @GetMapping("/residences")
    public List<Residence> displayResidences(){
       return  rentalServiceImpl.getResidences();
    }
    @PostMapping(value = "/residence")
    public void registerResidence(@Valid @RequestBody House house, Address address){
        rentalServiceImpl.addHouse(house, address);
    }

    @DeleteMapping("/delete/{residenceId}")
    public void deleteResidence(@PathVariable Integer residenceId){
        rentalServiceImpl.deleteResidence(residenceId);
    }

    @PutMapping("/contracts/{contractId}")
    public Long replaceContract(@PathVariable Long contractId,@RequestBody Contract newContract) {
        return rentalServiceImpl.updateContract(contractId,newContract);
    }
    @GetMapping("/payments")
    public List<Payment> displayUnderPayments(double amount){
        return  rentalServiceImpl.underPayments(amount);
    }
}