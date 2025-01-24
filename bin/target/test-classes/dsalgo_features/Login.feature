@DsalgoLogin
Feature: Testing Login
  I want to Enter details and Login

  @Login1
  Scenario Outline: Verify that user is able to land on Login Page
    Given The user is on the DS Algo Home Page
    When The user should click the Sign in link
    Then The user should be redirected to Sign in page

  @Login2
  Scenario Outline: user able to land on Home page after entering valid Username and Password fields from excel sheet
    Given The user is on the DS Algo Sign in Page
    When user clicks login to DsAlgo application for valid with "<Sheetname>" and <Rownumber>
    Then user should see an <Sheetname> and <Rownumber>
    And The user should logout from Ds Algo page

    Examples: 
      | Sheetname | Rownumber |
      | Login     |         0 |

  @Login3
  Scenario Outline: user able to land on Home page after entering invalid Username and Password fields from excel sheet
    Given The user is on the DS Algo Sign in Page
    When user clicks login to DsAlgo application for valid with "<Sheetname>" and <Rownumber>
    Then user can see an <Sheetname> and <Rownumber>

    Examples: 
      | Sheetname | Rownumber |
      | Login1    |         0 |
      | Login1    |         1 |
      | Login1    |         2 |

  @Login4
  Scenario Outline: user able to land on Home page after entering invalid Username and Password fields from excel sheet
    Given The user is on the DS Algo Sign in Page
    When user clicks login to DsAlgo application for valid with "<Sheetname>" and <Rownumber>
    Then user can able to see an <Sheetname> and <Rownumber>

    Examples: 
      | Sheetname | Rownumber |
      | Login1    |         3 |
      | Login1    |         4 |
      | Login1    |         5 |
