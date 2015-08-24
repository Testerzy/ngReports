package com.testng.reports._actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.testng.reports.admin.MainConfig;

public class ActionTests1 extends MainConfig{

	private Actions action;
	
	@Test(priority=1)
	public void DragAndDrop() {
		action = new Actions(driver);
		driver.get("http://www.w3schools.com/html/html5_draganddrop.asp");
		action.dragAndDrop(driver.findElement(By.id("drag1")), driver.findElement(By.id("div2"))).build().perform();
	}
	
//	@Test(priority=2)
	public void Slider() {
		action = new Actions(driver);
		driver.get("https://jqueryui.com/slider/");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='slider']/span")));
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
	    int width = driver.findElement(By.xpath("//div[@id='slider']")).getSize().getWidth();
		action.clickAndHold(slider).moveByOffset(width/2, 0).release().build().perform();
		driver.switchTo().defaultContent();
	}
	
//	@Test(priority=3)
	public void Scrolling() {
		driver.get("https://www.linkedin.com/");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		driver.navigate().to("https://www.linkedin.com/directory/companies?trk=hb_ft_companies_dir");
		WebElement element = driver.findElement(By.linkText("Import/Export"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		
		driver.navigate().to("https://www.linkedin.com/job/?trk=hb_ft_jobs");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		
	}
	
}
