Feature: Title of your feature

  @tag1
  Scenario Outline: Title of your scenario
    Given Load Application Url "https://himachalhillportercompany.org/Recruitments.aspx"
    When Fetch Data from "<SheetName>" with <RowNumber>
    And Enter candidate aadhar no
    And Enter candidate name
    And Enter candidate Father name
    And Enter canddate Date of birth
    And Enter candidate Address 

    Examples: 
      | SheetName | RowNumber |
      | Sheet1    |         0 |
