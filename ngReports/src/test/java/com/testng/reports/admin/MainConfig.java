package com.testng.reports.admin;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class MainConfig {

	protected RemoteWebDriver driver;
	protected WebDriverWait wait;
	private DesiredCapabilities capabilities;
	
	@BeforeTest
//	@Parameters({ "seleniumHost", "seleniumPort", "browser", "version" })
	@Parameters({ "seleniumHost", "seleniumPort", "browser" })
//	public void setUp(String seleniumHost, int seleniumPort, String browser, @Optional("37") String version) throws Exception {
	public void setUp(String seleniumHost, int seleniumPort, String browser) throws Exception {
		if (browser.equalsIgnoreCase("firefox")){
			capabilities = new DesiredCapabilities();
//			capabilities.setCapability("browserName", "firefox");
			capabilities.setBrowserName("firefox");
		}else if (browser.equalsIgnoreCase("phantomjs")){
			capabilities = new DesiredCapabilities().phantomjs();
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "c:\\selenium\\lib\\phantomjs.exe");
		}
		
//		if (!version.isEmpty()){
//			capabilities.setVersion(version);
//		}
		
		driver = new RemoteWebDriver(new URL(seleniumHost + ":" + seleniumPort + "/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 20);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
	
}
