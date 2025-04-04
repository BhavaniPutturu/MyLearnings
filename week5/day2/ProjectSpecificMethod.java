package week5.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethod {
	public ChromeDriver driver;
	@BeforeMethod
	public void preCondition()
	{
		//to disable the browser notifications
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//to initialize ChromeDriver
		driver = new ChromeDriver(option);
		//to load the URL "https://login.salesforce.com"
		driver.get("https://login.salesforce.com");
		//Maximize the browser window
		driver.manage().window().maximize();
		//to add an implicit wait to ensure the web page elements are fully loaded 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//to enter the user name
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		//to enter the password
		driver.findElement(By.id("password")).sendKeys("Test@2025");
		//to click on the login button
		driver.findElement(By.id("Login")).click();
		
	}
	
	@AfterMethod
	public void postCondition()
	{
		//to close all opened windows
		driver.quit();
	}
}
