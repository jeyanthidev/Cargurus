package cargurusproject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Bycar extends BaseTest {
	
	@Test(priority=4,groups="ByCar")
	public void testByCar() throws Exception {
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
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_zip1")).click();
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_zip1")).sendKeys("60195");
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_distance")).click();
		    new Select(driver.findElement(By.id("newSearchHeaderForm_UsedCar_distance"))).selectByVisibleText("25 mi");
		    driver.findElement(By.id("newSearchHeaderForm_UsedCar_distance")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Radius'])[1]/following::input[1]")).click();
	}

}


