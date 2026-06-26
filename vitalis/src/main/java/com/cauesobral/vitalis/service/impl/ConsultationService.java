package com.cauesobral.vitalis.service.impl;

import com.cauesobral.vitalis.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {

    private final ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    // TODO: implementar registro de consulta quando ConsultationRequestDTO for criado
}
