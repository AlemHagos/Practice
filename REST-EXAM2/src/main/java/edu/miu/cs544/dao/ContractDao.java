package edu.miu.cs544.dao;
import edu.miu.cs544.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDao extends JpaRepository<Contract, Long> {
}
