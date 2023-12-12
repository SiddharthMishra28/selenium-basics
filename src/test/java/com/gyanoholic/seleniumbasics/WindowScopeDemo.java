package com.gyanoholic.seleniumbasics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowScopeDemo {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://formy-project.herokuapp.com/");
		driver.findElement(By.xpath("//li/a[contains(text(), 'Switch')]")).click();
		Thread.sleep(2000);
		String parentWindowHandle = driver.getWindowHandle();
		driver.findElement(By.id("new-tab-button")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles) {
			driver.switchTo().window(handle);
			Thread.sleep(2000);
		}
		driver.quit();
	}
}
