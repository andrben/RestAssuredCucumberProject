Feature: This feature will be used to test the CRUD operations on employee springboot application using Rest Assured
  I want to use this template for my feature file

  Scenario: This scenario will test the GET operation on Employee DB
    Given I have the endpoint as "http://3.84.15.226:8088/employees"
    When I perform the GET operation
    Then I get the response code as 200

  Scenario: This scenario will test the POST operation on Employee DB
    Given I have the endpoint as "http://3.84.15.226:8088/employees"
    When I perform the POST operation with below data
      | firstName | Tushar      |
      | lastName  | Gupta       |
      | salary    |        3000 |
      | email     | abc@xyz.com |
    Then I get the response code as 201
