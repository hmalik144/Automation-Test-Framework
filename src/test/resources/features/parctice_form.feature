Feature: Feature to test the practice form

  @SmokeTest @RegressionTest
  Scenario Outline: Check user can successfully submit a form with minimum mandatory valid credentials

    Given user is on practice form
    When user enters first name "<firstName>" and last name "<lastName>"
    And user selects gender "<gender>"
    And user enters email address "<emailAddress>"
    And user enters mobile number "<mobileNumber>"
    And user clicks submit button
    Then pop up is displayed

    Examples:
      | firstName | lastName | gender | emailAddress | mobileNumber |
      | Harvey    | Specter   | Male   | harvey.specter@pearson-specter.com |  2125096995 |
      | Rachel    | Zane      | Female   | rachel.zane@pearson-specter.com |  2125096965 |


#  @SmokeTest @RegressionTest
#  Scenario Outline: Check user can successfully submit a form with all the minimum valid credentials and 1 letter names
#
#    Given user is on practice form
#    When user enters first name "<firstName>" and last name "<lastName>"
#    And user selects gender "<gender>"
#    And user enters email address "<emailAddress>"
#    And user enters mobile number "<mobileNumber>"
#    And user clicks submit button
#    Then pop up is displayed
#
#    Examples:
#      | firstName | lastName | gender | emailAddress | mobileNumber |
#      | i    | j   | Male     | j@domain.com |  2125096995 |
#      | 2    | y   | Female   | y@domain.com |  2125096965 |
#
#
#  @RegressionTest
#  Scenario Outline: Check user cannot submit a form with if fields are empty
#
#    Given user is on practice form
#    When user enters first name "<firstName>" and last name "<lastName>"
#    And user selects gender "<gender>"
#    And user enters email address "<emailAddress>"
#    And user enters mobile number "<mobileNumber>"
#    And user clicks submit button
#    Then no pop up is displayed
#
#    Examples:
#      | firstName | lastName | gender | emailAddress | mobileNumber |
#      |           | Lastname  | Male     | name@domain.com |  2125096995 |
#      | FirstName |           | Female   | name@domain.com |  2125096965 |
#      | FirstName | Lastname  |          | name@domain.com |  2125096965 |
#      | FirstName | Lastname  | Other  |  |  2125096965 |
#      | FirstName | Lastname  | Other  | name@domain.com |   |
#
#  @RegressionTest
#  Scenario Outline: Check email address shows error if incorrect email string
#
#    Given user is on practice form
#    When user enters email address "<emailAddress>"
#    Then email input is displaying an error
#
#    Examples:
#      | emailAddress |
#      | namedomain.com |
#      | name@domain.c |
#      | @domain.com |

