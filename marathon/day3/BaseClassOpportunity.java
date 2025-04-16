package marathon.day3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClassOpportunity {
	public static ChromeDriver driver;
	String fileName;
	int index;
	@Parameters({"url", "userName", "passWord"})
	@BeforeMethod	
	public void preCondition(String url, String userName, String passWord)
	{
		 ChromeOptions options = new ChromeOptions();
	     options.addArguments("--disable-notifications");
	     driver = new ChromeDriver(options);
	     driver.manage().window().maximize();	     
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	     //to load the url
	     driver.get(url);
	     //to enter the username
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
		//read the data from excel
		return ReadDataFromOppExcel.getDataFromExcel(fileName, index); 
	 }
}
