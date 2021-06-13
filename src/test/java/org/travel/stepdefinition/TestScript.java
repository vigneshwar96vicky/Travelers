package org.travel.stepdefinition;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.travel.objectrepository.TravelPage;
import org.travel.resources.CommonAction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TestScript extends TravelPage {
	TravelPage i = new TravelPage();
	CommonAction ca = new CommonAction();
	String assertVal = "";
	Actions act = new Actions(driver);

	@Given("validiating the first page for title")
	public void validiating_the_first_page_for_title() throws IOException {
		String title = ca.title();
		System.out.println("%%%%%%%" + title + "%%%%%%%");
		//ca.takeScreen();
	}

	@Given("validiating for the module")
	public void validiating_for_the_module() {
		boolean verify = ca.verify(i.getLogo());
		if (verify) {
			System.out.println("%%%%%%%Logo is displayed%%%%%%");
		}
	}

	@When("validiating the module is clickable")
	public void validiating_the_module_is_clickable() throws IOException {
		ca.clickBot(i.getAuto());
		// (//h1)[1]
		//ca.takeScreen();

	}

	@When("validiating the action moves to current auto module")
	public void validiating_the_action_moves_to_current_auto_module() {
		List<WebElement> insurancePath2 = i.getInsurancePath();
		int k = 0;
		for (WebElement element : insurancePath2) {
			ca.wait(element);
			k++;
			if (k == insurancePath2.size()) {
				assertVal = assertVal + element.getText();
			} else {
				assertVal = assertVal + element.getText() + " / ";
			}
		}
		
	}

	@When("valiating the section")
	public void valiating_the_section() throws IOException {
		System.out.println("---------------------------------------------");
		ca.validate(assertVal, "Home / Car Insurance");
		//ca.takeScreen();
	}

	@Then("checking the browser action")
	public void checking_the_browser_action() throws IOException {
		ca.navigate("back");
		//ca.takeScreen();
	}
	
	@Given("User move to All product tab")
	public void user_move_to_All_product_tab() {
		act.moveToElement(i.getAllProductTab());
		act.build().perform();
	}

	@When("User clicks All product tab")
	public void user_clicks_All_product_tab() throws IOException, InterruptedException {
		System.out.println("Excel Loading");
		//Thread.sleep(3000);
		ca.clickBot(getAllProductTab());
		List<String> jd = ca.listVal(getAllTabInsurace());
		// ca.excelWrite(jd);
	}

	@When("User Stores the All Insurance products in Excel")
	public void user_Stores_the_All_Insurance_products_in_Excel() throws IOException, InterruptedException {
		//Thread.sleep(5000);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		List<WebElement> lt = getAllTabInsurace();
		for (WebElement lem : lt) {
			String text = lem.getText();
			if (text.contains("Home Insurance")) {
				lem.click();
				break;
			}
		}
		
		
	}

	@When("User Enters the ZipCode")
	public void user_Enters_the_ZipCode() throws InterruptedException {
		System.out.println("printing+++++++++++++++++++++++++");
		Thread.sleep(2000);
		
		try{
			act.moveToElement(getStartQuote2());
			act.build().perform();
			getZipCode2().sendKeys("10004");
			getZipCode2().sendKeys(Keys.ENTER);
		} catch(Exception e) {
			act.moveToElement(getStartQuote());
			act.build().perform();
			getZipCode().sendKeys("10005");
			ca.clickBot(getStartQuote());
		}
		System.out.println("****************************************");
	}

	@Then("User Navigates to Main page")
	public void user_Navigates_to_Main_page() throws InterruptedException {
		
	}

}
