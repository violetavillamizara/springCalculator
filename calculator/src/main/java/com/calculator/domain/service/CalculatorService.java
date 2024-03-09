package com.calculator.domain.service;

import com.calculator.persistence.Operation;

public interface CalculatorService {
    Operation sumar(double operand1, double operand2);
    Operation restar(double operand1, double operand2);
    Operation multiplicar(double operand1, double operand2);
    Operation dividir(double operand1, double operand2);
}
