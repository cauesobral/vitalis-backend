package com.cauesobral.vitalis.exception;

// Exceção de regra de negócio — lançada quando uma operação viola uma regra do domínio
// Estende RuntimeException: não precisa ser declarada na assinatura do método (unchecked)
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
