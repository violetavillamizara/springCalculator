package com.calculator.domain.service;

import com.calculator.persistence.Operation;

import java.util.List;

public interface OperationService {
    List<Operation> getAllOperations();
    Operation getOperationById(Long id);
    Operation addOperation(Operation operation);
    Operation updateOperation(Long id, Operation operation);
    void deleteOperation(Long id);
}
