#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


@tag
Feature: Search customer
  
  @tag1
    Scenario: Search customer by EmailID
    Given user launch the crome browser 
    When user enter URL "https://admin-demo.nopcommerce.com/login"
    And User enter valid Email as "admin@yourstore.com" and password as "admin"
    And click on login button
    When user click on Customers menu
    And user click on Customers
    And Enter Customer Details
    When User click on search button
    Then user should found Email in the search table
    And close the browser
    