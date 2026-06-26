package com.cauesobral.vitalis.util;

import java.time.LocalDate;
import java.time.Period;

// Utilitário de datas
public class DateUtils {

    private DateUtils() {
        // Classe utilitária: construtor privado impede instanciação
    }

    // Calcula a idade em anos completos a partir da data de nascimento
    public static int calculateAge(LocalDate birthDate) {
        if (birthDate == null) return 0;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Verifica se a data está no passado
    public static boolean isPastDate(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }
}
