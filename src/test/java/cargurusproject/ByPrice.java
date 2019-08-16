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

public class ByPrice implements CarGuruConstant {

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
		ArrayList<Object[]> dataList = Excelutil.getDataFromExcel("Price", new String[] { "Zipcode", "Radius",
				"YearStart", "YearEnd", "Price Mini", "Price Max", "Max Milelage", "Transmission" });
		return dataList.iterator();
	}

	@Test(dataProvider = "getTestData", priority = 2, groups = "ByUsedCar")
	public void testByPrice(String zipcode, String radius, String yearStart, String yearEnd, String priceMini,
			String priceMax, String maxMilelage, String transmission) {
		System.out.println("inside testByPrice ");
		driver.get("https://www.cargurus.com/");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::span[2]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[1]/preceding::label[1]")).click();
		driver.findElement(By.id("newPriceSearchHeaderForm_zip")).clear();
		driver.findElement(By.id("newPriceSearchHeaderForm_zip")).sendKeys(zipcode);

		driver.findElement(By.id("newPriceSearchHeaderForm_distance")).click();
		new Select(driver.findElement(By.id("newPriceSearchHeaderForm_distance"))).selectByVisibleText(radius);
		driver.findElement(By.id("newPriceSearchHeaderForm_distance")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Years'])[2]/following::select[1]"))
				.click();
		new Select(driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Years'])[2]/following::select[1]")))
						.selectByVisibleText(yearStart);
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Years'])[2]/following::select[1]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[4]/following::select[1]"))
				.click();
		new Select(driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[4]/following::select[1]")))
						.selectByVisibleText(yearEnd);
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[4]/following::select[1]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price'])[2]/following::select[1]"))
				.click();
		new Select(driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price'])[2]/following::select[1]")))
						.selectByVisibleText(priceMini);
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price'])[2]/following::select[1]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[5]/following::select[1]"))
				.click();
		new Select(driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[5]/following::select[1]")))
						.selectByVisibleText(priceMax);
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='to'])[5]/following::select[1]"))
				.click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Maximum Mileage'])[2]/following::select[1]"))
				.click();
		new Select(driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Maximum Mileage'])[2]/following::select[1]")))
						.selectByVisibleText(maxMilelage);
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Maximum Mileage'])[2]/following::select[1]"))
				.click();
		driver.findElement(By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Transmission'])[2]/following::input[1]"))
				.click();
		driver.findElement(By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Find Dealers'])[1]/preceding::input[1]"))
				.click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}
}
