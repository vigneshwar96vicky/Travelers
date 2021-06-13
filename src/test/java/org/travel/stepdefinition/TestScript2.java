package org.travel.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.travel.objectrepository.TravelPage;
import org.travel.resources.CommonAction;

import cucumber.api.java.en.When;

public class TestScript2 extends TravelPage {
	CommonAction j = new CommonAction();
	TravelPage k = new TravelPage();
	Actions act = new Actions(driver);
	@When("User Choose to continue with quote")
	public void user_Choose_to_continue_with_quote() {
	    j.clickBot(getConitnueQuote());
	}
}
