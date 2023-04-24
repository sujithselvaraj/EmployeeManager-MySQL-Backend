package com.sujith.employeemanager;

import com.sujith.employeemanager.model.Employeee;
import com.sujith.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeResource
{

    private final EmployeeService employeeService;


    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employeee>> getAllEmployees()
    {
        List<Employeee> employeees=employeeService.findAllEmployees();
        return new ResponseEntity<>(employeees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employeee> getEmployeeById(@PathVariable("id") Long id)
    {
        Employeee employeee=employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employeee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employeee> addEmployee(@RequestBody Employeee employeee)
    {
        Employeee newEmployee=employeeService.addEmployee(employeee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employeee> updateEmployee(@RequestBody Employeee employeee)
    {
        Employeee updateEmployee=employeeService.updateEmployee(employeee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
