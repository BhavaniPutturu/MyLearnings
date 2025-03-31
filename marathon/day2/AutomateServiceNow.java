/*
 * Testcase:2 Ordering mobile
==========================
Note: If you have your own Servicenow Credentials you can use it .

1. Launch ServiceNow application
2. Login with valid credentials username as admin and password 
3. Click-All Enter Service catalog in filter navigator and press enter or 
   Click the ServiceCatalog
4. Click on  mobiles
5. Select Apple iphone13pro
6. Choose yes option in lost or broken iPhone
7. Enter phonenumber as 99 in original phonenumber field
8. Select Unlimited from the dropdown in Monthly data allowance
9. Update color field to SierraBlue and storage field to 512GB
10. Click on Order now option
11. Verify order is placed and copy the request number
 */
package marathon.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class AutomateServiceNow {
	public ChromeDriver driver;
	public Shadow shadow;
	public static void main(String[] args) {
		AutomateServiceNow objASN = new AutomateServiceNow();
		objASN.login();
		objASN.selectMobiles();
		objASN.enterDetails();
		objASN.printDetails();
	}
	//To log into the ServiceNow site
	public void login()
	{
		//to create ChromeOptions object
		ChromeOptions option = new ChromeOptions();
		//to add "--disable-notifications" to disable the notifications in browser
		option.addArguments("--disable-notifications");
		//creating the ChromeDriver object to launch the browser and inspect the web elements.
		driver = new ChromeDriver(option);
		//to open the given url in chrome browser
		driver.get("https://dev186929.service-now.com/");
		//to maximise the browser window
		driver.manage().window().maximize();
		//to wait till 30 seconds of every operation
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//to enter the username
		driver.findElement(By.id("user_name")).sendKeys("admin");
		//to enter the password
		driver.findElement(By.id("user_password")).sendKeys("2AqjN!lC2!Vy");
		//to click on login button
		driver.findElement(By.id("sysverb_login")).click();
		
	}
	//To select the Mobiles option
	public void selectMobiles()
	{
		if(driver != null)
		{
			//creating Shadow object to access the web elements under the shadow-root
			shadow = new Shadow(driver);
			//to add the implicit wait
			shadow.setImplicitWait(10);
			//to click on All tab
			shadow.findElementByXPath("//div[text()='All']").click();
			//to locate the input field "filter"
			WebElement elementFilter = shadow.findElementByXPath("//input[@id='filter']");
			//to enter "Service catalog" in filter field
			elementFilter.sendKeys("Service catalog");
			//to select "Service catalog" from the options
			shadow.findElementByXPath("//mark[text()='Service Catalog']").click();
			//to locate the required frame
			WebElement elementFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
			//to shift the driver focus to the frame
			driver.switchTo().frame(elementFrame);
			//to select the "Mobiles" link
			driver.findElement(By.xpath("//h2[contains(text(), 'Mobiles')]")).click();
			//to select "Apple iPhone 13"
			driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
		}
	}
	//To enter the details of product
	public void enterDetails()
	{
		//executes only when the driver is instantiated
		if(driver!=null)
		{
			//to choose yes option in lost or broken iPhone
			driver.findElement(By.xpath("//label[@class='radio-label'][1]")).click();
			//to enter phone number as 99 in original phone number field
			driver.findElement(By.xpath("//span[text()='What was the original phone number?']/"
					+ "ancestor::label/parent::div/following::input[2]")).sendKeys("99");
			//to Select Unlimited from the dropdown in Monthly data allowance
			WebElement elementMDA = driver.findElement(By.xpath("//span[text()='Monthly data allowance']/following::select"));
			Select selMDA = new Select(elementMDA);
			selMDA.selectByValue("Unlimited");
			//to update color field to Blue
			driver.findElement(By.xpath("//label[text()='Blue']")).click();
			//to select 512GB for storage field
			driver.findElement(By.xpath("//label[contains(text(),'512')]")).click();
			//to click on Order now option
			driver.findElement(By.id("oi_order_now_button")).click();		
		}
	}
	//To print the order details
	public void printDetails()
	{
		if(driver!=null)
		{
			//to verify the placed order
			WebElement elementOrderSuccess = driver.findElement(By.xpath("//dt[contains(text(),'Order Placed')]/following::b"));
			System.out.println("Order placed on " + elementOrderSuccess.getText());
			//to print the request number
			WebElement elementReqNum = driver.findElement(By.xpath("//dt[contains(text(),'Request Number')]/following::b"));
			System.out.println("Request number:" + elementReqNum.getText());
		}
	}
}
