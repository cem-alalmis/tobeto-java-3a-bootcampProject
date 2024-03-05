package com.tobeto.bootcampProject.webApi.controllers;


import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcampProject.business.responses.update.applicant.UpdateApplicantResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantsController extends BaseController {
    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateApplicantRequest request) {
        return handleDataResult(applicantService.add(request));
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody UpdateApplicantRequest request) {
        return handleDataResult(applicantService.update(request));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        this.applicantService.delete(id);
        return handleResult(applicantService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return handleDataResult(applicantService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(applicantService.getById(id));
    }
}
