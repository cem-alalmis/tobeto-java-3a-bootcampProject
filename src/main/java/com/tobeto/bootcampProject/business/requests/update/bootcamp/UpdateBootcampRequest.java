package com.tobeto.bootcampProject.business.requests.update.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampRequest {
    private int id;
    private String name;
    private int instructorId; //Neden field'larda Instructor türündeyken burada int türünde InstructorId?
    private LocalDate startDate;
    private LocalDate endDate;
    private int bootcampStateId;
}
