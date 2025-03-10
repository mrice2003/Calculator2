package com.example.calculator;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "*")
public class CalculatorController {
    private final Calculator calculator = new Calculator();

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestBody CalculatorRequest request) {
        try {
            calculator.setNumbers(request.getNum1(), request.getNum2());
            calculator.setOperation(request.getOperation());
            calculator.calculate();
            return ResponseEntity.ok(calculator.getResult());
        } catch (ArithmeticException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/result")
    public ResponseEntity<Double> getResult() {
        return ResponseEntity.ok(calculator.getResult());
    }
} 