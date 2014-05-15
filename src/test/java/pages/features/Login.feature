Feature: Login

#  Scenario Outline: Login with various users
#
#    Given I enter a <username> and a <password>
#    When I submit
#    Then I see the <outcome>
#  Examples:
#    | username | password | outcome |
#    | agileway | testwise | sucess  |


  Scenario: Login successfully

    Given I enter valid credentials
    When I submit
    Then I see login is success


  Scenario: Login successfully

    Given I enter valid end-user credentials
    When I submit
    Then I see login is success