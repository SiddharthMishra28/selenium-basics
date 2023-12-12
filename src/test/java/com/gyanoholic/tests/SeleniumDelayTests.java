package com.gyanoholic.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumDelayTests {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
	}
	
//	@Test
//	public void waitForReadyStateTest() {
//		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
//		// IMPLICIT WAIT
//		// WAIYS FOR SPECIFIED # OF SECONDS WITHOUT POLLING
//		// AND THROWING EXCEPTION
//		driver.findElement(By.id("populate-text")).click();
//		String data = driver.findElement(By.xpath("//h2[text()='Selenium Webdriver']")).getText();
//		System.out.println(data);
//	}
	
	@Test
	public void explicitWaitTest() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		driver.findElement(By.id("populate-text")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Selenium Webdriver']")));
		String data = driver.findElement(By.xpath("//h2[text()='Selenium Webdriver']")).getText();
		System.out.println(data);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
