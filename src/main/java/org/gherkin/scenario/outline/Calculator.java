package org.gherkin.scenario.outline;

public class Calculator {

    private int firstNumber;
    private int secondNumber;
    private int result;

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void add() {
        this.result = this.firstNumber + this.secondNumber;
    }

    public int getResult() {
        return this.result;
    }
}
