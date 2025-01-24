@linkedlist
Feature: Testing linked list Page

  Background: The user able to land on Home page after entering valid Username and Password fields
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering valid Username and Password

  @TS_linkedlist_01
  Scenario: Verify that user is able to navigate to linked list page
    Given The user is in home page after Sign in
    When The user clicks the "Getting Started" button under Linked List section
    Then The user should navigate to linked list home page

  #Introduction
  @TS_linkedlist_02
  Scenario: Verify that user is able to navigate to "Introduction" page
    Given The user is on the "Linked list" page after clicks on get started
    When User has to click on"Introduction" link
    Then The user should be redirected to the "Introduction" of linked list Page

  @TS_linkedlist_03
  Scenario: Verify that user is able to navigate to try editor page in introduction page
    Given User is in "Introduction" page
    When The users clicks on "Try Here" button in "Introduction" page
    Then The user should be redirected to the page having an try Editor with a Run button

  @TS_linkedlist_04
  Scenario Outline: Verify that user is able to see output for valid python code for Introduction page
    Given The user is in the try Editor page for Introduction page
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for valid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         0 |

  @TS_linkedlist_04
  Scenario Outline: Verify that user is able to see output for invalid python code for Introduction page
    Given The user is in the try Editor page for Introduction page
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for invalid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         1 |
      | phythoncode |         2 |

  #Creating Linked List
  @TS_linkedlist_05
  Scenario: Verify that user is able to navigate to "Creating Linked List" page
    Given User is in "Introduction" page
    When User has to clicks on the"Creating Linked List" link
    Then The user should be redirected to the "Creating Linked List" of linked list Page

  @TS_linkedlist_06
  Scenario: The user is able to navigate to a page having an try Editor from "Creating Linked List" page
    Given User is in "Creating Linked List" page
    When The user clicks "Try Here" button in a Creating Linked List page
    Then The user should be redirected to the page having an try Editor with a Run button

  @TS_linkedlist_07
  Scenario Outline: Verify that user is able to see output for valid python code for Creating Linked List page
    Given The user is in try Editor page of Creating Linked List page
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for valid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         0 |

  @TS_linkedlist_08
  Scenario Outline: Verify that user is able to see output for invalid python code for Introduction page
    Given The user is in try Editor page of Creating Linked List page
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for invalid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         1 |
      | phythoncode |         2 |

  #Types of Linked List
  @TS_linkedlist_09
  Scenario: Verify that user is able to navigate to "Types of Linked List" page
    Given User is in "Creating Linked List" page
    When User has to click on"Types of Linked List" link
    Then The user should be redirected to the "Types of Linked List" of linked list Page

  @TS_linkedlist_10
  Scenario: Verify that user is able to navigate to try editor page in Types of Linked List page
    Given User is in "Types of Linked List" page
    When User clicks "Try Here" button in a Types of Linked List page
    Then The user should be redirected to the page having an try Editor with a Run button

  Scenario Outline: Verify that user is able to see output for valid python code for Introduction page
    Given The user is in the try Editor page for Types of Linked List page
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for valid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         0 |

  @TS_linkedlist_11
  Scenario Outline: Verify that user is able to see output for invalid python code for Introduction page
    Given The user is in the try Editor page for Types of Linked List page
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for invalid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         1 |
      | phythoncode |         2 |

  #Implement Linked List in Python
  @TS_linkedlist_12
  Scenario: Verify that user is able to navigate to "Implement Linked List in Python" page
    Given User is in "Types of Linked List" page
    When User has to click on"Implement Linked List in Python" link
    Then The user should be redirected to the "Implement Linked List in Python" of linked list Page

  @TS_linkedlist_13
  Scenario: Verify that user is able to navigate to try editor page in Implement Linked List in Python
    Given User is in "Implement Linked List in Python" page
    When The user clicks "Try Here" button in a Implement Linked List in Python page
    Then The user should be redirected to the page having an try Editor with a Run button

  @TS_linkedlist_14
  Scenario Outline: Verify that user is able to see output for valid python code for Introduction page
    Given The user is in the try Editor page for Implement Linked List
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for valid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         0 |

  @TS_linkedlist_15
  Scenario Outline: Verify that user is able to see output for invalid python code for Introduction page
    Given The user is in the try Editor page for Implement Linked List
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for invalid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         1 |
      | phythoncode |         2 |

  #Traversal
  @TS_linkedlist_16
  Scenario: Verify that user is able to navigate to "Traversal" page
    Given User is in "Implement Linked List in Python" page
    When User has to click on"Traversal" link
    Then The user should be redirected to the "Traversal" of linked list Page

  @TS_linkedlist_17
  Scenario: Verify that user is able to navigate to try editor page in Traversal
    Given User is in "Traversal" page
    When The user clicks "Try Here" button in a Traversal page
    Then The user should be redirected to the page having an try Editor with a Run button

  @TS_linkedlist_18
  Scenario Outline: Verify that user is able to see output for valid python code for Introduction page
    Given The user is in the try Editor page for Traversal
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for valid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         0 |

  @TS_linkedlist_19
  Scenario Outline: Verify that user is able to see output for invalid python code for Introduction page
    Given The user is in the try Editor page for Traversal
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for invalid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         1 |
      | phythoncode |         2 |

  #Insertion
  @TS_linkedlist_20
  Scenario: Verify that user is able to navigate to "Insertion" page
    Given User is in "Traversal" page
    When User has to click on"Insertion" link
    Then The user should be redirected to the "Insertion" of linked list Page

  @TS_linkedlist_21
  Scenario: Verify that user is able to navigate to try editor page in Insertion
    Given User is in "Insertion" page
    When The user clicks "Try Here" button in a Insertion page
    Then The user should be redirected to the page having an try Editor with a Run button

  @TS_linkedlist_22
  Scenario Outline: Verify that user is able to see output for valid python code for Introduction page
    Given The user is in the try Editor page for Insertion
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for valid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         0 |

  @TS_linkedlist_24
  Scenario Outline: Verify that user is able to see output for invalid python code for Introduction page
    Given The user is in the try Editor page for Insertion
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for invalid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         1 |
      | phythoncode |         2 |

  #Deletion
  @TS_linkedlist_25
  Scenario: Verify that user is able to navigate to "Deletion" page
    Given User is in "Insertion" page
    When User has to click on"Deletion" link
    Then The user should be redirected to the "Deletion" of linked list Page

  @TS_linkedlist_26
  Scenario: Verify that user is able to navigate to try editor page in Deletion
    Given User is in "Deletion" page
    When The user clicks "Try Here" button in a Deletion page
    Then The user should be redirected to the page having an try Editor with a Run button

  @TS_linkedlist_27
  Scenario Outline: Verify that user is able to see output for valid python code for Introduction page
    Given The user is in the try Editor page for Deletion
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for valid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         0 |

  @TS_linkedlist_28
  Scenario Outline: Verify that user is able to see output for invalid python code for Introduction page
    Given The user is in the try Editor page for Deletion
    When User gets inputs from <Sheetname> and <RowNumber> in try Editor and click on Run
    Then User should be able to see output in the console Output for invalid data from <Sheetname> and <RowNumber>

    Examples: 
      | Sheetname   | RowNumber |
      | phythoncode |         1 |
      | phythoncode |         2 |

  #Practice questions
  @TS_linkedlist_29
  Scenario: Verify that user is able to navigate to "Practice Questions" Page for Linked List page
    Given User has to clicks "Introduction" link
    When The user clicked on the "Practice Questions" link
    Then The user should be redirected to Practice Questions of Linked List Page
