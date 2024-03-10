package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcampProject.business.requests.create.application.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.application.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.create.application.CreateApplicationResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.application.GetAllApplicantionResponse;
import com.tobeto.bootcampProject.business.responses.get.applicationState.GetAllApplicationStateResponse;
import com.tobeto.bootcampProject.business.responses.update.applicant.UpdateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.update.application.UpdateApplicationResponse;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

import javax.xml.crypto.Data;
import java.util.List;

public interface ApplicationService {
    DataResult<CreateApplicationResponse> add(CreateApplicationRequest request);

    DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest request);

    Result delete(int id);

    DataResult<List<GetAllApplicantionResponse>> getAll();

    DataResult<GetAllApplicantionResponse> getById(int id);


}
