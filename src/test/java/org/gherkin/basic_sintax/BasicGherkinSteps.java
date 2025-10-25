package org.gherkin.basic_sintax;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasicGherkinSteps {

    @When("the Maker starts a game")
    public void startGame() {
        System.out.println("Game started by the Maker");
    }

    @Then("the Maker waits for a Breaker to join")
    public void waitForPlayers() {
        System.out.println("Maker is waiting for Breaker to join");
    }

    @Given("the Maker has started a game with the word \"silky\"")
    public void startGameNamed() {
        System.out.println("Game started by the Maker with the word 'silky'");
    }

    @When("the Breaker joins the Maker's game")
    public void breakerJoinsGame() {
        System.out.println("Breaker has joined the Maker's game");
    }

    @Then("the Breaker must guess a word with 5 characters")
    public void breakerAttemptsToGuessWord() {
        System.out.println("Breaker is attempting to guess a 5-character word");
    }
}
