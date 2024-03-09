package com.calculator.domain.service;

import com.calculator.domain.repository.OperationRepository;
import com.calculator.persistence.Operation;
import com.calculator.web.exception.ArgumentoInvalido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    private final OperationRepository operationRepository;

    @Autowired
    public CalculatorServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public Operation sumar(double operand1, double operand2) {
        double result = operand1 + operand2;
        Operation newOp = new Operation("suma", operand1, operand2, result);
        return operationRepository.save(newOp);
    }

    @Override
    public Operation restar(double operand1, double operand2) {
        double result = operand1 - operand2;
        Operation newOp = new Operation("resta", operand1, operand2, result);
        return operationRepository.save(newOp);
    }

    @Override
    public Operation multiplicar(double operand1, double operand2) {
        double result = operand1 * operand2;
        Operation newOp = new Operation("multiplicacion", operand1, operand2, result);
        return operationRepository.save(newOp);
    }

    @Override
    public Operation dividir(double operand1,double operand2) {
        if(operand2!=0) {
            double result = operand1 / operand2;
            Operation newOp = new Operation("division", operand1, operand2, result);
            return operationRepository.save(newOp);
        } else{
            throw new ArgumentoInvalido("no se puede dividir por 0");
        }
    }
}
