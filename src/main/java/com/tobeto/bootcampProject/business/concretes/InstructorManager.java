package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.requests.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.instructor.CreateInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetAllInstructorResponse;
import com.tobeto.bootcampProject.business.responses.get.instructor.GetInstructorResponse;
import com.tobeto.bootcampProject.business.responses.update.instructor.UpdateInstructorResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataaccess.abstracts.InstructorRepository;
import com.tobeto.bootcampProject.entities.concretes.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class InstructorManager implements InstructorService {

    private ModelMapperService modelMapperService;
    private InstructorRepository instructorRepository;

    @Override
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest request) {

        Instructor instructor = modelMapperService.forRequest().map(request, Instructor.class);
        instructorRepository.save(instructor);
        CreateInstructorResponse response = modelMapperService.forResponse().map(instructor, CreateInstructorResponse.class);
        return new SuccessDataResult<CreateInstructorResponse>(response, "Eğitmen başarıyla eklendi");

    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest request) {

        Instructor instructor = instructorRepository.findById(request.getId()).orElseThrow();
        Instructor updatedInstructor = modelMapperService.forRequest().map(request, Instructor.class);

        instructor.setFirstName(updatedInstructor.getFirstName() != null ? updatedInstructor.getFirstName() : instructor.getFirstName());
        instructor.setLastName(updatedInstructor.getLastName() != null ? updatedInstructor.getLastName() : instructor.getLastName());
        instructor.setCompanyName(updatedInstructor.getCompanyName() != null ? updatedInstructor.getCompanyName() : instructor.getCompanyName());
        instructor.setEmail(updatedInstructor.getEmail() != null ? updatedInstructor.getEmail() : instructor.getEmail());
        instructor.setUserName(updatedInstructor.getUserName() != null ? updatedInstructor.getUserName() : instructor.getUserName());
        instructor.setNationalIdentity(updatedInstructor.getNationalIdentity() != null ? updatedInstructor.getNationalIdentity() : instructor.getNationalIdentity());
        instructor.setDateOfBirth(updatedInstructor.getDateOfBirth() != null ? updatedInstructor.getDateOfBirth() : instructor.getDateOfBirth());

        instructorRepository.save(instructor);
        UpdateInstructorResponse response = modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<UpdateInstructorResponse>(response, "Eğitmen güncellendi");
    }

    @Override
    public Result delete(int id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow();
        instructorRepository.delete(instructor);
        return new SuccessResult("Eğitmen silindi");
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {
        List<Instructor> instructors = instructorRepository.findAll();
        List<GetAllInstructorResponse> instructorResponses = instructors.stream().map(instructor -> modelMapperService.forResponse()
                .map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllInstructorResponse>>(instructorResponses,"Tüm eğitmenler getirildi");
    }

    @Override
    public DataResult<GetInstructorResponse> getById(int id) {
        Instructor instructor = instructorRepository.getById(id);
        GetInstructorResponse response = modelMapperService.forResponse().map(instructor, GetInstructorResponse.class);
        return new SuccessDataResult<GetInstructorResponse>(response,"Eğitmen getirildi");
    }
}
