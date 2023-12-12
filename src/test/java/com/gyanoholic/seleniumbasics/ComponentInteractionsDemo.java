package com.gyanoholic.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComponentInteractionsDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://formy-project.herokuapp.com/");
//		driver.findElement(By.xpath("//li/a[text()='Enabled and disabled elements']")).click();
//		Thread.sleep(2000);
//		if(driver.findElement(By.id("disabledInput")).isEnabled()) {
//			driver.findElement(By.id("disabledInput")).sendKeys("I will never execute!");
//		}
		
		driver.findElement(By.xpath("//li/a[text()='File Upload']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("file-upload-field")).sendKeys("./sample.txt");
		Thread.sleep(3000);
		driver.quit();
	}
}
