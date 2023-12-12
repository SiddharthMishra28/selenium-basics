package com.gyanoholic.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FormBotAutomation {

		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://form-bot-anvsystems.pages.dev/");
			driver.findElement(By.name("firstname")).sendKeys("Sid");
			driver.findElement(By.name("lastname")).sendKeys("mishra");
			driver.findElement(By.name("email")).sendKeys("sid@test.com");
			driver.findElement(By.xpath("//input[@value='male']")).click();
			driver.findElement(By.name("phone")).sendKeys("098765432");
			Select countryDropdown = new Select(driver.findElement(By.name("country")));
			countryDropdown.selectByVisibleText("India");
			driver.findElement(By.xpath("//input[@value='Java']")).click();
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			String tableDataXpath = "//table/tbody/tr/td";
			int numCells = driver.findElements(By.xpath(tableDataXpath)).size();
//			for(int i=1; i<=numCells; i++) {
//				String data = driver.findElement(By.xpath(tableDataXpath+"["+i+"]")).getText();
//			}
			String firstName_Actual = driver.findElement(By.xpath(tableDataXpath+"[1]")).getText();
			String firstName_Expected = "Siddharth";
			Assert.assertEquals(firstName_Actual, firstName_Expected);
			driver.quit();
		}
}
