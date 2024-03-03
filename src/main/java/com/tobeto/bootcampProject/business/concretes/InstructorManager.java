package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.InstructorService;
import com.tobeto.bootcampProject.business.requests.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcampProject.business.responses.create.instructor.CreateInstructorResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataaccess.abstracts.InstructorRepository;
import com.tobeto.bootcampProject.entities.concretes.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class InstructorManager implements InstructorService {

    private ModelMapperService modelMapperService;
    private InstructorRepository instructorRepository;
    @Override
    public CreateInstructorResponse add(CreateInstructorRequest request) {

        Instructor instructor = modelMapperService.forRequest().map(request,Instructor.class);
        instructorRepository.save(instructor);
        CreateInstructorResponse response = modelMapperService.forResponse().map(instructor,CreateInstructorResponse.class);
        return response;

    }
}
