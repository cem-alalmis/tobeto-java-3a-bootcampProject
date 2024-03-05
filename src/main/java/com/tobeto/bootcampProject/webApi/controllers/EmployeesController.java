package com.tobeto.bootcampProject.webApi.controllers;

import com.tobeto.bootcampProject.business.abstracts.EmployeeService;

import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController extends BaseController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateEmployeeRequest request) {
        return handleDataResult(employeeService.add(request));
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody UpdateEmployeeRequest request) {
        return handleDataResult(employeeService.update(request));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        this.employeeService.delete(id);
        return handleResult(employeeService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return handleDataResult(employeeService.getAll());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(employeeService.getById(id));
    }

}
