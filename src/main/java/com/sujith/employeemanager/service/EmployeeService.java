package com.sujith.employeemanager.service;

import com.sujith.employeemanager.exception.UserNotfoundException;
import com.sujith.employeemanager.model.Employeee;
import com.sujith.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService
{
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employeee addEmployee(Employeee employeee){
        employeee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employeee);
    }


    public List<Employeee> findAllEmployees()

    {
        return employeeRepo.findAll();
    }

    public Employeee updateEmployee(Employeee employeee)
    {
        return employeeRepo.save(employeee);
    }

    public Employeee findEmployeeById(Long id)
    {
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotfoundException("User by id "+id+"was not found"));
    }

    public void deleteEmployee(Long id)
    {
        employeeRepo.deleteEmployeeById(id);
    }


}
