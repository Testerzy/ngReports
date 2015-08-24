package com.testng.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testng.reports.admin.MainConfig;


public class DifferentListener extends MainConfig{

	@Test
	public void FirstTest(){
		driver.get("http://google.pl");
		driver.findElement(By.name("q")).sendKeys("testowanie");
		driver.findElement(By.name("btnG")).click();
		wait.until(ExpectedConditions.titleContains("testowanie"));
		WebElement result = driver.findElement(By.id("center_col"));
//		Assert.assertTrue(result.getText().contains("testowanie"));
		Assert.assertTrue(ExpectedConditions.textToBePresentInElement(result, "testowanie").apply(driver));
	}
	
}
