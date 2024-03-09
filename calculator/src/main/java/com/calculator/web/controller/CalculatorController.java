package com.calculator.web.controller;

import com.calculator.domain.service.CalculatorService;
import com.calculator.persistence.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
@CrossOrigin("*")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/suma")
    public Operation sumar(@RequestParam("num") double operand1, @RequestParam("num2") double operand2){
        return calculatorService.sumar(operand1,operand2);
    }

    @PostMapping("/resta")
    public Operation restar(@RequestParam("num") double operand1, @RequestParam("num2") double operand2){
        return calculatorService.restar(operand1,operand2);
    }

    @PostMapping("/multiplicacion")
    public Operation multiplicar(@RequestParam("num") double operand1, @RequestParam("num2") double operand2){
        return calculatorService.multiplicar(operand1,operand2);
    }

    @PostMapping("/division")
    public Operation dividir(@RequestParam("num") double operand1, @RequestParam("num2") double operand2){
        return calculatorService.dividir(operand1,operand2);
    }
}
