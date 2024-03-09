package com.tobeto.bootcampProject.business.responses.create.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {
    private int id;
    private int instructorId;
    private int bootcampStateId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
