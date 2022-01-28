Feature: Customer


Background: Below steps are common for every scenario
		Given user launch the crome browser 
    When user enter URL "https://admin-demo.nopcommerce.com/login"
    And User enter valid Email as "admin@yourstore.com" and password as "admin"
    And click on login button
    Then Page title should be "Dashboard / nopCommerce administration"


@sanity
  Scenario: Add Customer
    When user click on Customers menu
    And user click on Customers
    And user click on Add new
    Then user can view Add new Customer page
    When user enter customers info
    And user click on Save button
    Then user can view the message "The new customer has been added successfully"
    And close the browser
    
    
@regression
  Scenario: Search customer by EmailID
    When user click on Customers menu
    And user click on Customers
    And Enter Customer Details
    When User click on search button
    Then user should found Email in the search table
    And close the browser
    
@regression    
  Scenario: Search customer by Name
    When user click on Customers menu
    And user click on Customers
    And Enter Customer FirstName
    And Enter Customer LastName
    When User click on search button
    Then user should found Name in the search table
    And close the browser
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    