package com.tobeto.bootcampProject.webApi.controllers;


import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcampProject.business.responses.update.applicant.UpdateApplicantResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantsController {
    private ApplicantService applicantService;

    @PostMapping
    public CreateApplicantResponse add(@RequestBody CreateApplicantRequest request) {
        return applicantService.add(request);
    }

    @PutMapping("update")
    public UpdateApplicantResponse update(@RequestBody UpdateApplicantRequest request) {
        return applicantService.update(request);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        this.applicantService.delete(id);

    }

    @GetMapping("/getAll")
    public List<GetAllApplicantResponse> getAll(){
        return applicantService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetApplicantResponse getById(@PathVariable int id){
        return applicantService.getApplicant(id);
    }
}
