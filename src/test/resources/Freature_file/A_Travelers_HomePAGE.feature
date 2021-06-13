#Author: 1996m.vigneshwar@gmail.com
@test1
Feature: Module page load page verification

  Scenario: verify All product
    Given User move to All product tab
    When User clicks All product tab
    And User Stores the All Insurance products in Excel
    And User Enters the ZipCode
    Then User Navigates to Main page
    
  Scenario: verify Aauto module
    Given validiating the first page for title
    And validiating for the module
    When validiating the module is clickable
    And validiating the action moves to current auto module
    And valiating the section
    Then checking the browser action
