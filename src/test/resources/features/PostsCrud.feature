Feature: CRUD of /posts endpoint

  Scenario Outline: Create a post in /posts endpoint with new user
#    This step is for creating a new user in /users endpoint
    Given creates a new user with name "NameName"
    When user creates a post with title "<title>" and body "<body>" for user "NameName"
    Then check if new post is created with title "<title>" and body "<body>" for user "NameName"

    Examples:
      | title          | body                           |
      | Just any title | Just any body you can think of |