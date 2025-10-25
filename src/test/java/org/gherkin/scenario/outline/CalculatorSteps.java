package org.gherkin.scenario.outline;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CalculatorSteps {

    private final Calculator calculator = new Calculator();

    @Given("I have entered first number: {int} into the calculator")
    public void enterFirstNumber(int number1) {
        System.out.println("Entering first number: " + number1);
        calculator.setFirstNumber(number1);
    }

    @And("I have entered second number: {int} into the calculator")
    public void enterSecondNumber(int number2) {
        System.out.println("Entering second number: " + number2);
        calculator.setSecondNumber(number2);
    }

    @When("I press add")
    public void performAddition() {
        System.out.println("Performing addition");
        calculator.add();
    }

    @Then("the result should be {int} on the screen")
    public void displayResult(Integer result) {
        System.out.println("The result is: " + result);
        Assertions.assertEquals(result, calculator.getResult());
    }
}
