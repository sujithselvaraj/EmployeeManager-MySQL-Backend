package com.sujith.employeemanager.repo;

import com.sujith.employeemanager.model.Employeee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employeee,Long>
{

    void deleteEmployeeById(Long id);

    Optional<Employeee> findEmployeeById(Long id);
}
