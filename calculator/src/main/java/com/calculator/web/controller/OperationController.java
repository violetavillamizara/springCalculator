package com.calculator.web.controller;

import com.calculator.domain.repository.OperationRepository;
import com.calculator.domain.service.OperationService;
import com.calculator.persistence.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operations")
@CrossOrigin("*")
public class OperationController {
    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public List<Operation> getAllOperations(){return operationService.getAllOperations();}

    @GetMapping("/{id}")
    public Operation getOperationbyId(@PathVariable Long id){return operationService.getOperationById(id);}

    @PostMapping
    public Operation addOperation(@RequestBody Operation operation){
        return operationService.addOperation(operation);
    }

    @PutMapping("/{id}")
    public Operation updateOperation(@PathVariable Long id, @RequestBody Operation operation){
        return operationService.updateOperation(id, operation);
    }
    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable Long id){operationService.deleteOperation(id);}
}
