package cargurusproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.util.Excelutil;

public class ByCarSearch {
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		System.setProperty(CarGuruConstant.WEBDRIVER, CarGuruConstant.WEBDRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> dataList =Excelutil.getDataFromExcel("search",new String[] {"Make","Model","YearStart","YearEnd","Zipcode","Radius"});
		return dataList.iterator();
		
	}
	@Test(dataProvider = "getTestData",priority=1,groups="ByUsedCar")
	public void byCarSearchTest (String make, String model, String yearStart, String yearEnd, String zipcode, String radius){
		
		 driver.get("https://www.cargurus.com/");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::span[2]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New Search'])[1]/following::label[1]")).click();
		    driver.findElement(By.className("ft-make-selector")).click();
		    new Select(driver.findElement(By.className("ft-make-selector"))).selectByVisibleText(make);
		    driver.findElement(By.className("ft-make-selector")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[2]")).click();
		    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[2]"))).selectByVisibleText(model);
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[2]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[1]")).click();
		    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[1]"))).selectByVisibleText(yearStart);
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[1]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/following::select[1]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/following::select[1]")).click();
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_zip")).click();
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_zip")).sendKeys(zipcode);
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_distance")).click();
		    new Select(driver.findElement(By.id("newSearchHeaderForm_UsedCar_distance"))).selectByVisibleText(radius);
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_distance")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Radius'])[1]/following::input[1]")).click();
		    // Assert.assertEquals( driver.findElement(By.id("displayedListingsCount")).getText().contains("out of"), true);
		    
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();

	}

}
