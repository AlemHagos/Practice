package edu.miu.cs544;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDao.findById(id).orElse(null);
    }

    @Override
    public Employee getEmployeeByJobTitle(String jobTitle) {
        return employeeDao.findEmployeeByJobTitle(jobTitle);
    }

    @Override
    public void addNewEmployee(Employee employee) {
        employeeDao.save(employee);

    }

    @Override
    public Employee updateEmployee(Long id, Employee newEmployee) {
        Employee employee = employeeDao.findById(id).get();

        employee.setGivenNames(newEmployee.getGivenNames());
        employee.setFamilyNames(newEmployee.getFamilyNames());
        employee.setEmail(newEmployee.getEmail());
        employee.setJobTitle(newEmployee.getJobTitle());
        employee.setSalary(newEmployee.getSalary());
        employeeDao.save(employee);
        return newEmployee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeDao.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesMore(double amount) {
        List<Employee> employees = employeeDao.findAmountGreaterThan(amount);
        List<Employee> elites = new ArrayList<>();
        for (Employee e : employees){
            if (e.getSalary()>amount){
                elites.add(e);
            }
        }
        return elites;
    }
}




