package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.EmployeeService;
import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataaccess.abstracts.EmployeeRepository;
import com.tobeto.bootcampProject.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private ModelMapperService modelMapperService;
    private EmployeeRepository employeeRepository;

    @Override
    public CreateEmployeeResponse add(CreateEmployeeRequest request) {

        Employee employee = modelMapperService.forRequest().map(request,Employee.class);
        employeeRepository.save(employee);
        CreateEmployeeResponse response = modelMapperService.forResponse().map(employee,CreateEmployeeResponse.class);
        return response;
    }
}
