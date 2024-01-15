Feature: Test facebook application

  Scenario: Validate facebook register page
    Given user open "edge" browser
    And user is on register page
    When user enter valid "Nikita","Patil","nikita@gmail.com","nikita@123",
    And user select "20","Dec","2000" and select gender as "Female"
