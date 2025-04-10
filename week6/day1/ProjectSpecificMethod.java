package week6.day1;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {
	public RemoteWebDriver driver;
	
	@Parameters({"url", "userName", "passWord", "browser", "disable"})
	@BeforeMethod	
	public void preCondition(String url, String userName, String passWord, String browser, String disable )
	{
		//to disable the browser notifications
		ChromeOptions option = new ChromeOptions();
		option.addArguments(disable);
		//to initialize ChromeDriver
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver(option);
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		//to load the URL "https://login.salesforce.com"
		driver.get(url);
		//Maximize the browser window
		driver.manage().window().maximize();
		//to add an implicit wait to ensure the web page elements are fully loaded 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//to enter the user name
		driver.findElement(By.id("username")).sendKeys(userName);
		//to enter the password
		driver.findElement(By.id("password")).sendKeys(passWord);
		//to click on the login button
		driver.findElement(By.id("Login")).click();
		
	}
	
	@AfterMethod
	public void postCondition()
	{
		//to close all opened windows
		driver.quit();
		
	}
	 @DataProvider(name="fetchData") 
	 public String[][] fetchData() throws IOException 
	 { 
		String[][] data = new String[3][1];
		data[0][0] = "Bhavani";
		data[1][0] = "Bhavani P";
		data[2][0] = "Bhavani Putturu";
		return data; 
	 }
}
