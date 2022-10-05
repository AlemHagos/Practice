package edu.miu.cs544;

import java.util.List;

public interface EmployeeService {
     List<Employee> getAllEmployees();
     Employee getEmployeeById(Long id);
     Employee getEmployeeByJobTitle(String jobTitle);
     void addNewEmployee(Employee employee);
     Employee updateEmployee(Long id,Employee newEmployee);
     void deleteEmployeeById(Long id);
     List<Employee> getEmployeesMore(double amount);
}
