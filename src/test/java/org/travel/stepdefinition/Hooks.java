package org.travel.stepdefinition;


import org.travel.resources.CommonAction;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends CommonAction {
	@Before
	public void lan() {
		launch("https://www.travelers.com/");
	}

	@After
	public void closeB() {
		//driver.quit();
	}
}
