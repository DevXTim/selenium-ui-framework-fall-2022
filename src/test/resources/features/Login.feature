Feature: Login feature

  @Smoke @jenkins @ui
  Scenario: Verify user is able to login with valid credentials
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on Sign In button
    Then verify user is successfully logged in to the account


  @api
  Scenario: Register new user via api and check user created
    When sends request to create user with following fields:
      | address      | country | dob        | emailAddress | firstName | gender | homePhone  | lastName      | locality  | mobilePhone | password        | postalCode | region | ssn      | title | workPhone |
      | fakerAddress | US      | 12/12/2000 | fakerEmail   | user1     | female | fakerPhone | fakerLastName | fakerCity | [blank]     | MatchFormat123! | 55555      | LA     | fakerSSN | Mr.   | [blank]   |