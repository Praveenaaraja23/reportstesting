@Register
Feature: Testing Register Page

  Scenario: The user launches GetStarted page in DsAlgo portal
    Given The user navigates DSAlgo portal with url
    When The user chooses to clicks on Getstarted button
    Then User should be navigated to home page

  @Ts_Register01_emptyexcel
  Scenario Outline: The user Registers with Invalid(blank) credentials
    Given User initiates by clicking on Register link in home page
    When User wants to enter data from excel sheet <Sheetname> and <RowNumber>
    Then User is expected to see the Message in console output from excel sheet <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname | RowNumber |
      | Register  |         0 |
      | Register  |         1 |
      | Register  |         2 |
      | Register  |         3 |

  @Ts_Register02_invalidexcel
  Scenario Outline: The user Registers with Invalid credentials
    Given User initiates by clicking on Register link in home page
    When User wants to enter data from excel sheet <Sheetname> and <RowNumber>
    Then User is expected to see the Error message in console output from excel sheet <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname | RowNumber |
      | Register  |         4 |
      | Register  |         5 |
      | Register  |         6 |
      | Register  |         7 |
      | Register  |         8 |
      | Register  |         9 |

  @Ts_Register0_validexcel
  Scenario Outline: The user Registers with Valid credentials
    Given User initiates by clicking on Register link in home page
    When User wants to enter data from excel sheet <Sheetname> and <RowNumber>
    Then User is expected to navigate to home page and Message in console output from excel sheet <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname | RowNumber |
      | Register  |        10 |
