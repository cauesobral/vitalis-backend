package com.cauesobral.vitalis.util;

// Utilitário para validar CPF
// Algoritmo: cálculo dos dois dígitos verificadores
public class CpfUtils {

    private CpfUtils() {
        // Classe utilitária: construtor privado impede instanciação
    }

    // Remove máscara e valida o CPF
    public static boolean isValid(String cpf) {
        if (cpf == null) return false;

        // Remove pontos e traços: "123.456.789-09" → "12345678909"
        String cleaned = cpf.replaceAll("[.\\-]", "");

        if (cleaned.length() != 11) return false;

        // Rejeita CPFs com todos os dígitos iguais (ex: "11111111111")
        if (cleaned.chars().distinct().count() == 1) return false;

        // Valida o primeiro dígito verificador (posição 9)
        int firstDigit = calculateDigit(cleaned, 9);
        if (firstDigit != Character.getNumericValue(cleaned.charAt(9))) return false;

        // Valida o segundo dígito verificador (posição 10)
        int secondDigit = calculateDigit(cleaned, 10);
        return secondDigit == Character.getNumericValue(cleaned.charAt(10));
    }

    // Calcula um dígito verificador dado o CPF e o tamanho do trecho a calcular
    private static int calculateDigit(String cpf, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (length + 1 - i);
        }
        int remainder = (sum * 10) % 11;
        return (remainder == 10 || remainder == 11) ? 0 : remainder;
    }
}
