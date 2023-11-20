package org.example.doktor_babczynski.lab3.ex4.service;

public class CalculationService {
    private double num1;
    private double num2;
    private char mathematicalSymbol;

    public char getMathematicalSymbol() {
        return mathematicalSymbol;
    }

    public void setMathematicalSymbol(char mathematicalSymbol) {
        this.mathematicalSymbol = mathematicalSymbol;
    }


    public void setNum1(double  num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double add(){
        return num1+num2;
    }


    public double subtract(){
        return num1 - num2;
    }


    public double multiply(){
        return num1 * num2;
    }


    public double divide(){
        return num1/num2;
    }
}
