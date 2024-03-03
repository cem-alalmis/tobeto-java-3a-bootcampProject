package com.tobeto.bootcampProject.business.requests.create.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest {

    private String userName;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String nationalIdentity;

    private String email;

    private String password;

    private String about;
}
