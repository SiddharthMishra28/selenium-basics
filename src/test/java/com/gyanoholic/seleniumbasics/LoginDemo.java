package com.gyanoholic.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginDemo {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v2/");
		driver.findElement(By.name("uid")).sendKeys("mngr542003");
		driver.findElement(By.name("password")).sendKeys("nyseqAn");
//		driver.findElement(By.name("uid")).sendKeys("jslajdlsa");
//		driver.findElement(By.name("password")).sendKeys("msaldmsadjals");
//		driver.findElement(By.name("btnLogin")).click();
//		driver.switchTo().alert().accept();
		if(driver.getTitle().equalsIgnoreCase(" Guru99 Bank Manager HomePage ".trim())) {
			System.out.println("Login Successfull!");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='New Account']")).click();
		Thread.sleep(2000);
		Select accType = new Select(driver.findElement(By.name("selaccount")));
		accType.selectByVisibleText("Current");
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
