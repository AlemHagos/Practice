package edu.miu.cs544.dao;

import edu.miu.cs544.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {
 List<Payment> findByAmountLessThan(double amount);

}
