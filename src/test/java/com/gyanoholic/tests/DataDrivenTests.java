package com.gyanoholic.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gyanoholic.testevents.GlobalTestListener;

public class DataDrivenTests {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v2/");
	}
	
	@Test(dataProvider = "loginData")
	public void dataTest(String userId, String password) throws InterruptedException {
		// USER ID
		// PASSWORD
		// LOGIN BTN CLICK
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
		driver.findElement(By.name("uid")).sendKeys(userId);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
	}
	
	@DataProvider(name = "loginData")
	public Object[][] testLoginProvider() throws IOException {
		FileInputStream fis = new FileInputStream("./testdata/studentdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis); //xlsx HSSFWorkbook
		XSSFSheet sheet = wb.getSheet("credentials");
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] testData = new Object[rowCount+1][colCount];
		for(int i=1; i<=rowCount; i++) {			
			for(int j=0; j<colCount; j++) {
				testData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(testData[i][j]);
			}
		}
		return testData;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
