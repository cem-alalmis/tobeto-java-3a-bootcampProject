package com.tobeto.bootcampProject.business.responses.get.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetBootcampResponse {
    private int id;
    private int instructorId;
    private int bootcampStateId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
