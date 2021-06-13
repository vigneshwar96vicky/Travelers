package org.travel.objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.travel.resources.CommonAction;

public class TravelPage extends CommonAction {
	public TravelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Auto']")
	private WebElement auto;
	
	@FindBy(xpath="//a[@class='logo']")
	private WebElement logo;
	
	@FindBy(xpath="//div[@class='breadcrumbs-content']/ul/li")
	private List<WebElement> insurancePath;
	
	@FindBy(xpath="//h3/a")
	private List<WebElement> allInsurancePro;
	
	@FindBy(id="tcom-home-pi-allproducts-icon")
	private WebElement allProductTab;
	
	@FindBy(xpath="//div[@class='explorer primary ']//h3/a")
	private List<WebElement> allTabInsurace;
	
	@FindBy(xpath="//div[@class='mm_input_form']/input")
	private WebElement zipCode;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement startQuote;
	
	@FindBy(xpath="//input[@name='zipCode']")
	private WebElement zipCode2;
	
	@FindBy(xpath="//input[@id='quote-zip-code']")
	private WebElement startQuote2;
	
	@FindBy(id="continue")
	private WebElement conitnueQuote;

	public WebElement getConitnueQuote() {
		return conitnueQuote;
	}

	public WebElement getStartQuote() {
		return startQuote;
	}

	public WebElement getZipCode() {
		return zipCode;
	}

	public List<WebElement> getAllTabInsurace() {
		return allTabInsurace;
	}

	public List<WebElement> getInsurancePath() {
		return insurancePath;
	}

	public WebElement getZipCode2() {
		return zipCode2;
	}

	public WebElement getStartQuote2() {
		return startQuote2;
	}

	public List<WebElement> getAllInsurancePro() {
		return allInsurancePro;
	}

	public WebElement getAllProductTab() {
		return allProductTab;
	}

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getAuto() {
		return auto;
	}
}
