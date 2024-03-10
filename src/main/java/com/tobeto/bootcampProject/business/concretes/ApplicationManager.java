package com.tobeto.bootcampProject.business.concretes;


import com.tobeto.bootcampProject.business.abstracts.ApplicationService;
import com.tobeto.bootcampProject.business.requests.create.application.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.application.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.create.application.CreateApplicationResponse;
import com.tobeto.bootcampProject.business.responses.get.application.GetAllApplicantionResponse;
import com.tobeto.bootcampProject.business.responses.update.application.UpdateApplicationResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.dataaccess.abstracts.ApplicationRepository;
import com.tobeto.bootcampProject.entities.concretes.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {

    private ModelMapperService modelMapperService;
    private ApplicationRepository applicationRepository;

    @Override
    public DataResult<CreateApplicationResponse> add(CreateApplicationRequest request) {

        Application application = modelMapperService.forRequest().map(request, Application.class);
        applicationRepository.save(application);
        CreateApplicationResponse response = modelMapperService.forResponse().map(application,CreateApplicationResponse.class);

        return new SuccessDataResult<CreateApplicationResponse>(response, "Başvuru başarıyla ekledi");
    }

    @Override
    public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest request) {

        Application application = applicationRepository.findById(request.getId()).orElseThrow();
        Application updatedApplication= modelMapperService.forRequest().map(request, Application.class);


        application.setApplicant(updatedApplication.getApplicant() != null ? updatedApplication.getApplicant() : application.getApplicant());
        application.setBootcamp(updatedApplication.getBootcamp() != null ? updatedApplication.getBootcamp() : application.getBootcamp());
        application.setApplicationState(updatedApplication.getApplicationState() != null ? updatedApplication.getApplicationState() : application.getApplicationState());

        applicationRepository.save(application);

        UpdateApplicationResponse response = modelMapperService.forResponse().map(application, UpdateApplicationResponse.class);
        return new SuccessDataResult<UpdateApplicationResponse>(response,"Başvuru başarıyla güncellendi");
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllApplicantionResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetAllApplicantionResponse> getById(int id) {
        return null;
    }
}
