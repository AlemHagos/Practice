package edu.miu.cs544;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long> {
    //@Query("SELECT e FROM Employee e WHERE e.jobTitle=?1")
           Employee findEmployeeByJobTitle(String jobTitle);
    List<Employee> findAmountGreaterThan(double amount);

}
