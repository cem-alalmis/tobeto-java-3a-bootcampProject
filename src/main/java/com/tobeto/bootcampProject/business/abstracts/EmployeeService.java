package com.tobeto.bootcampProject.business.abstracts;
import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;


public interface EmployeeService {
 CreateEmployeeResponse add(CreateEmployeeRequest request);
}
