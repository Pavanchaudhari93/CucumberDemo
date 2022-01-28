
Feature: Login

  @sanity
  Scenario: successfully login to nopcommerse with valid credential
    Given user launch the crome browser 
    When user enter URL "https://admin-demo.nopcommerce.com/login"
    And User enter valid Email as "admin@yourstore.com" and password as "admin"
    And click on login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout button
    Then Page title should be "Your store. Login"
    And close the browser
    
     @regression
    Scenario Outline: login data
    Given user launch the crome browser 
    When user enter URL "https://admin-demo.nopcommerce.com/login"
    And User enter valid Email as "<email>" and password as "<password>"
    And click on login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout button
    Then Page title should be "Your store. Login"
    And close the browser
    
    Examples:
    |email|password|
    |admin@yourstor3e.com|ad3min|
    |admin@yourstore.com|admin|
    |admin@yourstre.com|a23min|