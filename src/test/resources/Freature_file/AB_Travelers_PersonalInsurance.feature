#Author: your.email@your.domain.com
@test2
Feature: validating the Personal Insurance page
Background:
	Given User move to All product tab
		When User clicks All product tab
		And User Stores the All Insurance products in Excel
		And User Enters the ZipCode
 Scenario: validating personal Insurance
	When User Choose to continue with quote
		 