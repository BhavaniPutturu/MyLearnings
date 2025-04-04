/*Precondition: 
 * - Initialize ChromeDriver 
 * - Load the URL (http://leaftaps.com/opentaps/control/login) 
 * - Maximize the browser window 
 * - Add an implicit wait to ensure the webpage elements are fully loaded 
 * Requirements: 
 * - Enter the username and password. 
 * - Click on the Login button. 
 * - Click on the CRM/SFA link. 
 * - Click on the Contacts button. 
 * - Click on Merge Contacts. 
 * - Click on the widget of the "From Contact". 
 * - Click on the first resulting contact. 
 * - Click on the widget of the "To Contact". 
 * - Click on the second resulting contact. 
 * - Click on the Merge button. 
 * - Accept the alert. 
 * - Verify the title of the page. 
 */
package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeafTapsWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		//to disable the browser notifications
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//to initialize ChromeDriver		
		ChromeDriver driver = new ChromeDriver(option);
		//to load the URL (http://leaftaps.com/opentaps/control/login) 
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Maximize the browser window
		driver.manage().window().maximize();
		//to add an implicit wait to ensure the web page elements are fully loaded 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//to enter the user name
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//to enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//to click on the login button
		driver.findElement(By.className("decorativeSubmit")).click();
		//to click on the CRM/SFA link 
		driver.findElement(By.partialLinkText("CRM")).click();
		//to click on the Contacts button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//to click on Merge Contacts
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		//to click on the widget of the "From Contact". 
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Thread.sleep(5000);
		//to get the window handles
		Set<String> windows = driver.getWindowHandles();
		List<String> listWindows = new ArrayList<String>(windows);
		//to switch the driver focus to child window
		driver.switchTo().window(listWindows.get(1));
		Thread.sleep(5000);
		//to click on the first resulting contact. 
		driver.findElement(By.xpath("//table/tbody/tr/td/div/a")).click();
		//to switch the driver focus to main window
		driver.switchTo().window(listWindows.get(0));
		//to click on the widget of the "To Contact". 
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		windows = driver.getWindowHandles();
		listWindows = new ArrayList<String>(windows);
		Thread.sleep(2000);
		//to switch the driver focus to child window
		driver.switchTo().window(listWindows.get(1));
		//to click on the second resulting contact. 
		driver.findElement(By.xpath("(//table)[5]/tbody/tr/td/div/a")).click();
		//to switch the driver focus to main window
		driver.switchTo().window(listWindows.get(0));
		//to click on the Merge button		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(2000);
		//to accept the alert
		driver.switchTo().alert().accept();
		//to verify title of the page
		System.out.println("Current web page title is " + driver.getTitle());
	}

}
