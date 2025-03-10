package com.example.calculator;

public class Calculator {
    private double num1;
    private double num2;
    private String operation;
    private double result;

    public Calculator() {
        this.num1 = 0;
        this.num2 = 0;
        this.operation = "";
        this.result = 0;
    }

    public void setNumbers(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void calculate() {
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getOperation() {
        return operation;
    }

    public double getResult() {
        return result;
    }
} 