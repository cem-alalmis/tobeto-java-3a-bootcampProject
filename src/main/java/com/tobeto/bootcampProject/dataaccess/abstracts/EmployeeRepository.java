package com.tobeto.bootcampProject.dataaccess.abstracts;

import com.tobeto.bootcampProject.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
