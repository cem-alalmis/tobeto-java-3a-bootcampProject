package com.tobeto.bootcampProject.business.requests.update.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationRequest {
    private int id;
    private int applicantId; // Aynı soru :) JoinColumn name kısmında verdiğimiz isimle mi bağlantı kuruyoruz?
    private int bootcampId;
    private int applicationStateId;

    // Neden başvurunun idlerini kayıt için kullanıcıdan alıyorum??
}

