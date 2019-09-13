@Assessment
Feature: Apply Assessment

  Scenario Outline: Apply for jobs
    Given A user is on iLab page and want apply for jobs using browser "<Run_Browser>"
    And A user click on Careers
    And A user select South Africa hyperlink
    And A user click on the first available job hyperlink
    And A user select Apply online button
    And A user enter name as "<Name>" in the name field
    And A user enter email as "<Email>" in the email field
    And A user enter phone number in the phone field
    And A user clicks on Send button
    Then Validation message should be displayed

    Examples:
      |Run_Browser|Name        |Email                                |
      |CHROME     |Sfiso       |automationAssessment@iLABQuality.com |
      |IE         |Teddy       |automationAssessment@iLABQuality.com|

