package com.tobeto.bootcampProject.webApi.controllers;


import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.instructor.CreateInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetInstructorResponse;
import com.tobeto.bootcampProject.business.responses.update.instructor.UpdateInstructorResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorsController extends BaseController {
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateInstructorRequest request) {
        return handleDataResult(instructorService.add(request));
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody UpdateInstructorRequest request) {
        return handleDataResult(instructorService.update(request));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        this.instructorService.delete(id);
        return handleResult(instructorService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return handleDataResult(instructorService.getAll());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(instructorService.getById(id));
    }

}
