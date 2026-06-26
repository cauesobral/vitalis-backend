package com.cauesobral.vitalis.service.impl;

import com.cauesobral.vitalis.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // TODO: implementar CRUD de Doctor quando DoctorRequestDTO e DoctorResponseDTO forem criados
}
