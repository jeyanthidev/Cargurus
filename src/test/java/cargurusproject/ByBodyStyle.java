package cargurusproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.util.Excelutil;

public class ByBodyStyle{
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		// baseUrl = "https://www.katalon.com/";
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> dataList =Excelutil.getDataFromExcel("style",new String[] {"Body Style","Zipcode","Radius","YearStart","YearEnd","Price Mini","Price Max","Maximum milelage","Transmission"});
		return dataList.iterator();
	}
		
	
	@Test
	public void testBystlye() throws Exception {
		
		 

	driver.get("https://www.cargurus.com/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::span[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New Search'])[1]/following::label[2]")).click();
    driver.findElement(By.id("bodyTypeGroup")).click();
    new Select(driver.findElement(By.id("bodyTypeGroup"))).selectByVisibleText("Sedan");
    driver.findElement(By.id("bodyTypeGroup")).click();
    driver.findElement(By.id("newBodyStyleSearchHeaderForm_zip")).click();
    driver.findElement(By.id("newBodyStyleSearchHeaderForm_zip")).sendKeys("60195");
    driver.findElement(By.id("newBodyStyleSearchHeaderForm_distance")).click();
    new Select(driver.findElement(By.id("newBodyStyleSearchHeaderForm_distance"))).selectByVisibleText("25 mi");
    driver.findElement(By.id("newBodyStyleSearchHeaderForm_distance")).click();
    driver.findElement(By.name("startYear")).click();
    new Select(driver.findElement(By.name("startYear"))).selectByVisibleText("2017");
    driver.findElement(By.name("startYear")).click();
    driver.findElement(By.name("endYear")).click();
    new Select(driver.findElement(By.name("endYear"))).selectByVisibleText("2018");
    driver.findElement(By.name("endYear")).click();
    driver.findElement(By.name("minPrice")).click();
    new Select(driver.findElement(By.name("minPrice"))).selectByVisibleText("$28,000");
    driver.findElement(By.name("minPrice")).click();
    driver.findElement(By.name("maxPrice")).click();
    new Select(driver.findElement(By.name("maxPrice"))).selectByVisibleText("$160,000");
    driver.findElement(By.name("maxPrice")).click();
    driver.findElement(By.name("maxMileage")).click();
    new Select(driver.findElement(By.name("maxMileage"))).selectByVisibleText("170,000");
    driver.findElement(By.name("maxMileage")).click();
    driver.findElement(By.id("transmission-1")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/preceding::input[4]")).click();
    driver.findElement(By.xpath("//body")).click();
    driver.findElement(By.id("content")).click();
  }
	
	
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();

	}

}

	
	


