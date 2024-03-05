package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.EmployeeService;
import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataaccess.abstracts.EmployeeRepository;
import com.tobeto.bootcampProject.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private ModelMapperService modelMapperService;
    private EmployeeRepository employeeRepository;

    @Override
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest request) {

        Employee employee = modelMapperService.forRequest().map(request, Employee.class);
        employeeRepository.save(employee);
        CreateEmployeeResponse response = modelMapperService.forResponse().map(employee, CreateEmployeeResponse.class);
        return new SuccessDataResult<CreateEmployeeResponse>(response,"Çalışan başarıyla eklendi");
    }

    @Override
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(request.getId()).orElseThrow();
        Employee updatedEmployee = modelMapperService.forRequest().map(request, Employee.class);

        employee.setFirstName(updatedEmployee.getFirstName() != null ? updatedEmployee.getFirstName() : employee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName() != null ? updatedEmployee.getLastName() : employee.getLastName());
        employee.setPosition(updatedEmployee.getPosition() != null ? updatedEmployee.getPosition() : employee.getPosition());
        employee.setEmail(updatedEmployee.getEmail() != null ? updatedEmployee.getEmail() : employee.getEmail());
        employee.setUserName(updatedEmployee.getUserName() != null ? updatedEmployee.getUserName() : employee.getUserName());
        employee.setNationalIdentity(updatedEmployee.getNationalIdentity() != null ? updatedEmployee.getNationalIdentity() : employee.getNationalIdentity());
        employee.setDateOfBirth(updatedEmployee.getDateOfBirth() != null ? updatedEmployee.getDateOfBirth() : employee.getDateOfBirth());

        employeeRepository.save(employee);
        UpdateEmployeeResponse response = modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult<UpdateEmployeeResponse>(response,"Çalışan güncellendi");

    }

    @Override
    public Result delete(int id) {
        Employee employee = employeeRepository.getById(id);
        employeeRepository.delete(employee);
        return new SuccessResult("Çalışan silindi");
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponse> employeeResponses = employees.stream().map(employee -> modelMapperService.forResponse()
                .map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllEmployeeResponse>>(employeeResponses,"Tüm çalışanlar getirildi");
    }

    @Override
    public DataResult<GetEmployeeResponse> getById(int id) {
        Employee employee = employeeRepository.getById(id);
        GetEmployeeResponse response = modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);
        return new SuccessDataResult<GetEmployeeResponse>(response,"Çalışan getirildi");
    }
}
