package org.travel.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CommonAction {
	public static WebDriver driver;
	static int ran;
	String dr = System.getProperty("user.dir");
	//Driver Launch/////
	public static WebDriver launch(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("headless");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	//Random Number ran////
	public static int randomNum(){
		Random jd = new Random();
		ran = jd.nextInt(500000);
		return ran;
	}

	//To navigate/////
	public void navigate(String str) {
		if(str.equalsIgnoreCase("refresh")){
		driver.navigate().refresh();
		}
		else if(str.equalsIgnoreCase("back")){
			driver.navigate().back();
		}
		else if(str.startsWith("https")){
			driver.navigate().to(str);
		}else if(str.equalsIgnoreCase("forward")){
			driver.navigate().forward();
		}else{
			System.out.println("values:- refresh, back, https-url or forward");
		}
	}

	//click Action Using driver element//////
	public void clickBot(WebElement element) {
		try {
			try {
				element.isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Assert validation//////
	public void validate(String str1, String str2) {
		try {
			Assert.assertEquals(str1, str2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//To get Title of the Page//////
	public String title() {
		String title1 = null;
		try {
			title1 = driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return title1;
	}

	//To find the Element is displayed or not///////
	public boolean verify(WebElement element) {
		boolean i = false;
		try {
			boolean displayed = element.isDisplayed();
			if (displayed) {
				i = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	//Explicit wait////////////////
	public void wait(WebElement element){
		WebDriverWait j = new WebDriverWait(driver, 5);
		try{
		j.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//Take Screenshot/////////////
	public void takeScreen() throws IOException{
		File i = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(i, new File("E:\\Eclipse Workspace\\ProjectClass\\ZTravelers\\target\\screenshot\\image"+randomNum()+".png"));
	}
	
	//Write Excel////////////////
	public void excelWrite(List<String> element) throws IOException{
		File k = new File(".//target//excelStr//ExcelFile"+randomNum()+".xlsx");
		Workbook wb = new XSSFWorkbook();
		Sheet sht = wb.createSheet("Sheet"+randomNum());
		int i =0;
		for (String et : element) {
			Row cr = sht.createRow(i++);
			Cell cl = cr.createCell(0);
			cl.setCellValue(et);	
		}
		FileOutputStream fst = new FileOutputStream(k);
		wb.write(fst);
	}
	//To get list of values ////////////////
	public List<String> listVal(List<WebElement> element){
		List<String> k = new LinkedList<String>();
		try{
		for (WebElement elt : element) {
			String stg = elt.getText();
			System.out.println(stg);
			k.add(stg);
		}	
		}catch(Exception e){
			
		}
		return k;
	}
	//Property File read/////////
	public String readPrt(String crd) throws IOException{
		
		FileReader h = new FileReader(".//target//Creditials//creditials.properties");
		Properties prt = new Properties();
		prt.load(h);
		String property = prt.getProperty(crd);
		return property;
	}
	//create Txtfile///////
	public void txtFile() throws IOException{
		String k = dr+"/target/Creditials/trail.txt";
		k.replaceAll("\", ", "/");
		File j = new File(k);
		j.createNewFile();
	}
}








