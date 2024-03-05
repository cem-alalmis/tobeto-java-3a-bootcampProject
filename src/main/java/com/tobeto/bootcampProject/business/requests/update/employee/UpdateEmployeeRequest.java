package com.tobeto.bootcampProject.business.requests.update.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    private int id;

    private String userName;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String nationalIdentity;

    private String email;

    private String password;

    private String position;
}
