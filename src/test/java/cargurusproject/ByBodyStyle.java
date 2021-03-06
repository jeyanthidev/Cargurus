package cargurusproject;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.util.Excelutil;


public class ByBodyStyle extends BaseTest {
		
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> dataList =Excelutil.getDataFromExcel("style",new String[] {"Body Style","Zipcode","Radius","YearStart","YearEnd","Price Mini","Price Max","Max Milelage","Transmission"});
		return dataList.iterator();
	}
		
	

	@Test(dataProvider = "getTestData",priority=3,groups="ByBodyStyle")
	public void testBystlye(String bodyStyle, String zipcode, String radius, String yearStart, String yearEnd, String priceMini,String priceMax,String maxMilelage,String transmission ){
		System.out.println("inside testBystlye ");
		driver.get("https://www.cargurus.com/");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='España'])[1]/following::span[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New Search'])[1]/following::label[2]")).click();
	    driver.findElement(By.id("bodyTypeGroup")).click();
	    new Select(driver.findElement(By.id("bodyTypeGroup"))).selectByVisibleText(bodyStyle);
	    driver.findElement(By.id("bodyTypeGroup")).click();
	    driver.findElement(By.id("newBodyStyleSearchHeaderForm_zip")).click();
	    driver.findElement(By.id("newBodyStyleSearchHeaderForm_zip")).clear();
	    driver.findElement(By.id("newBodyStyleSearchHeaderForm_zip")).sendKeys(zipcode);
	    driver.findElement(By.id("newBodyStyleSearchHeaderForm_distance")).click();
	    new Select(driver.findElement(By.id("newBodyStyleSearchHeaderForm_distance"))).selectByVisibleText(radius);
	    driver.findElement(By.id("newBodyStyleSearchHeaderForm_distance")).click();
	    driver.findElement(By.name("startYear")).click();
	    new Select(driver.findElement(By.name("startYear"))).selectByVisibleText(yearStart);
	    driver.findElement(By.name("startYear")).click();
	    driver.findElement(By.name("endYear")).click();
	    new Select(driver.findElement(By.name("endYear"))).selectByVisibleText(yearEnd);
	    driver.findElement(By.name("endYear")).click();
	    driver.findElement(By.name("minPrice")).click();
	    new Select(driver.findElement(By.name("minPrice"))).selectByVisibleText(priceMini);
	    driver.findElement(By.name("minPrice")).click();
	    driver.findElement(By.name("maxPrice")).click();
	    new Select(driver.findElement(By.name("maxPrice"))).selectByVisibleText(priceMax);
	    driver.findElement(By.name("maxPrice")).click();
	    driver.findElement(By.name("maxMileage")).click();
	    new Select(driver.findElement(By.name("maxMileage"))).selectByVisibleText(maxMilelage);
	    driver.findElement(By.name("maxMileage")).click();
	    driver.findElement(By.id("transmission-1")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/preceding::input[4]")).click();
	    driver.findElement(By.xpath("//body")).click();
	    driver.findElement(By.id("content")).click();
  }
	

}

	
	


