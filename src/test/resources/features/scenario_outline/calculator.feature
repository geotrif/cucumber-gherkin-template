Feature: Calculator
  Simple calculator functionality

  Scenario Outline: Add two numbers
    Given I have entered first number: <number1> into the calculator
    And I have entered second number: <number2> into the calculator
    When I press add
    Then the result should be <result> on the screen

    Examples:
      | number1 | number2 | result |
      | 2       | 3       | 5      |
      | -1      | 1       | 0      |
      | 0       | 0       | 0      |
      | 123     | 456     | 579    |