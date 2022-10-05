package edu.miu.cs544;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/home")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> displayEmployees(){
       return  employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/employees/{jobTitle}")
    public Employee getEmployeeTitle(@PathVariable String jobTitle){
        return employeeService.getEmployeeByJobTitle(jobTitle);
    }
    @PostMapping(value = "/employee", consumes = {"application/json"})
    public void registerEmployee(@Valid @RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee replaceEmployee(@PathVariable Long id,@RequestBody Employee newEmployee) {
        return employeeService.updateEmployee(id,newEmployee);
   }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }
   @GetMapping("/elites")
   public List<Employee> getEmployeesMore(double amount) {
        return employeeService.getEmployeesMore(amount);
   }
}