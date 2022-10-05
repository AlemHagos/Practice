package edu.miu.cs544.dao;

import edu.miu.cs544.domain.Residence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidenceDao extends JpaRepository<Residence,Integer> {
     List<Residence> findByIdAndContractActive(Integer id, boolean status);
}
