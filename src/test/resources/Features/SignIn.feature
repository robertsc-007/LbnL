#Description : Testing of Excercise No1
Feature: YourStore Register Account

  Scenario: Mandatory Fields
    Given User is in the register page
    When User does not fill any field
    And User Submits
    Then Error message detailing what mandatory fields are missing

  Scenario Outline: Duplicate Email
    Given User is in the register page
    When User fills <name> <lastname> <telephone> <password> <confirmpass> <email> with scenario description
    And User Submits
    Then A <message> detailing the warning

    Examples: 
      | name       | lastname | telephone | password | confirmpass | email                       | message                               |
      | Alessandro | Silva    | 953105988 |    12345 |       12345 | alessandro.silva@oktana.com | E-Mail Address is already registered! |

  Scenario Outline: Invalid Email
    Given User is in the register page
    When User fills <name> <lastname> <telephone> <password> <confirmpass> <email> with scenario description
    And User Submits
    Then A <message> detailing the warning

    Examples: 
      | name       | lastname | telephone | password | confirmpass | email                  | message                      |
      | Alessandro | Silva    | 953105988 |    12345 |       12345 | alessandro.silvaoktana | does not appear to be valid! |

  Scenario Outline: Mismatch Password
    Given User is in the register page
    When User fills <name> <lastname> <telephone> <password> <confirmpass> <email> with scenario description
    And User Submits
    Then A <message> detailing the warning

    Examples: 
      | name       | lastname | telephone | password     | confirmpass | email                    | message                                       |
      | Alessandro | Silva    | 953105988 | 1234dadadad5 |      123875 | 123absnuevoss@oktana.com | Password confirmation does not match password |

  Scenario Outline: Successful register
    Given User is in the register page
    When User fills <name> <lastname> <telephone> <password> <confirmpass> <email> with scenario description
    And User Submits
    Then A <message> detailing the warning

    Examples: 
      | name       | lastname | telephone | password | confirmpass | email                                        | message                        |
      | Alessandro | Silva    | 953105988 |    12345 |       12345 | alesssandro.si3lvapnuevomasnuevod@oktana.com | Your Account Has Been Created! |

  Scenario Outline: Invalid data
    Given User is in the register page
    When User fills <name> <lastname> <telephone> <password> <confirmpass> <email> with scenario description
    And User Submits
    Then A <message> detailing the warning

    Examples: 
      | name        | lastname | telephone | password | confirmpass | email                       | message                 |
      | Aless@andro | Si#lva   | 953105988 |    12345 |       12345 | alleess77nuevazp@oktana.com | field has invalid data! |

  Scenario Outline: Missing Privacy Policy's box
    Given User is in the register page
    When User fills <name> <lastname> <telephone> <password> <confirmpass> <email> with scenario description
    And User doesnt check checking Privacy Policy box
    And User Submits
    Then A <message> detailing the warning

    Examples: 
      | name       | lastname | telephone | password | confirmpass | email                                 | message                      |
      | Alessandro | Silva    | 953105988 |    12345 |       12345 | alessaanndro.silvaprobando@oktana.com | agree to the Privacy Policy! |
