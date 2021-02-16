package com.qa.seleniumTesting.tdlTesting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Sql(scripts = { "classpath:schema-test.sql",
		"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class TDLSeleniumTesting {

	private static RemoteWebDriver driver;
	private static WebElement targ;
	private final String URL = "http://localhost:8080/create.html";
	private static ExtentReports report;
	private static ExtentTest test;

	@BeforeAll
	public static void beforeAll() {

		report = new ExtentReports("target/TestReports/index.html", true);

		// driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

		ChromeOptions config = new ChromeOptions();
		config.setHeadless(true);//  stops the window pop up if true -  can reduce the time of the
									// runtime test
		driver = new ChromeDriver(config);
		driver.manage().window().setSize(new Dimension(1366, 786)); // setting dimension of test window
	}
	
	@AfterEach
	public void endTest() {
		report.endTest(test);
	}
	
	@AfterAll
	public static void afterAll() {
		//quit driver
		driver.quit();
		//clean up extent report
		report.flush();
		report.close();
		
	}
	
	@Test
	public void createToDo() {
		
		test = report.startTest("Create To Do Test");
		
		driver.get(URL);
		//clicking create button via xpath
		targ = driver.findElement(By.xpath("/html/body/button"));
		targ.click();
		
		//entering example data
		targ = driver.findElement(By.id("toDoTitle"));
		targ.sendKeys("CREATE - Selenium User Acceptance Test");
		
		targ = driver.findElement(By.xpath("//*[@id=\"createbutton\"]/div/div/div[3]/button"));
		targ.click();
		
		// checking if it was successful
		targ = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"createConfirm\"]/p")));
		String result = targ.getText();
		String expected = "has been created. Head over to the Read page and click Read all to view the task ID";
		
		if(result.contains(expected)) {
			test.log(LogStatus.PASS, expected);
		}else {
			test.log(LogStatus.FAIL, "failed creation");
		}
		
		//assertions
		assertThat(result.concat(expected));
	}
	

}
