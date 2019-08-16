package cargurusproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Bycar {
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		System.setProperty(CarGuruConstant.WEBDRIVER, CarGuruConstant.WEBDRIVER_PATH);
		driver = new ChromeDriver();
		// baseUrl = "https://www.katalon.com/";
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testLogin() throws Exception {
		
		 driver.get("https://www.cargurus.com/");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::span[2]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New Search'])[1]/following::label[1]")).click();
		    driver.findElement(By.className("ft-make-selector")).click();
		    new Select(driver.findElement(By.className("ft-make-selector"))).selectByVisibleText("Nissan");
		    driver.findElement(By.className("ft-make-selector")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[2]")).click();
		    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[2]"))).selectByVisibleText("Rogue");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[2]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[1]")).click();
		    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[1]"))).selectByVisibleText("2017");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::select[1]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/following::select[1]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/following::select[1]")).click();
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_zip")).click();
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_zip")).sendKeys("60195");
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_distance")).click();
		    new Select(driver.findElement(By.id("newSearchHeaderForm_UsedCar_distance"))).selectByVisibleText("25 mi");
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_distance")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Radius'])[1]/following::input[1]")).click();
		    // Assert.assertEquals( driver.findElement(By.id("displayedListingsCount")).getText().contains("out of"), true);
		    
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();

	}

}
