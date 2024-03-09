package com.calculator.domain.service;

import com.calculator.domain.repository.OperationRepository;
import com.calculator.persistence.Operation;
import com.calculator.web.exception.OperacionNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService{
    private final OperationRepository operationRepository;

    @Autowired
    public OperationServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    @Override
    public Operation getOperationById(Long id) {
        Optional<Operation> optionalOperation = operationRepository.findById(id);
        return optionalOperation.orElseThrow(() -> new OperacionNotFound("Operacion no encontrada"));
    }

    @Override
    public Operation addOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public Operation updateOperation(Long id, Operation newOperation) {
        return operationRepository.findById(id)
                .map(operation -> {
                    operation.setOperationType(newOperation.getOperationType());
                    operation.setOperand1(newOperation.getOperand1());
                    operation.setOperand2(newOperation.getOperand2());
                    operation.setResult(newOperation.getResult());
                    operation.setTimeStamp(newOperation.getTimeStamp());
                    return operationRepository.save(operation);
                }).orElse(null);
    }

    @Override
    public void deleteOperation(Long id) {
        operationRepository.deleteById(id);
    }
}
