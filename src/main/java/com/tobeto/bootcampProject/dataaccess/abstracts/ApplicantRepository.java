package com.tobeto.bootcampProject.dataaccess.abstracts;

import com.tobeto.bootcampProject.entities.concretes.Applicant;
import com.tobeto.bootcampProject.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {
    Applicant getById(int id);
    Applicant getByEmail(String email);
}
