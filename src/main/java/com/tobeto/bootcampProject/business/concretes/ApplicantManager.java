package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicantService;
import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataaccess.abstracts.ApplicantRepository;
import com.tobeto.bootcampProject.entities.concretes.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ModelMapperService modelMapperService;
    private ApplicantRepository applicantRepository;

    @Override
    public CreateApplicantResponse add(CreateApplicantRequest request) {

        Applicant applicant = modelMapperService.forRequest().map(request,Applicant.class);
        applicantRepository.save(applicant);
        CreateApplicantResponse response = modelMapperService.forResponse().map(applicant,CreateApplicantResponse.class);
        return response;
    }
}
