package com.tobeto.bootcampProject.business.responses.update.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampResponse {
    private int id;
    private int instructorId;
    private int bootcampStateId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
