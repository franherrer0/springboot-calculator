Feature: calculator add operation

  Scenario: client wants to add two numbers
    When the client calls /vx/calc/add with values 1.0 and 2.0
    Then the client receives answer as 3.0

  Scenario: client wants to subtract two numbers
    When the client calls /vx/calc/sub with values 5.0 and 3.0
    Then the client receives answer as 2.0
    
  Scenario: client wants to subtract two numbers
    When the client calls /vx/calc/sub with values 212.8 and 11.5
    Then the client receives answer as 201.3