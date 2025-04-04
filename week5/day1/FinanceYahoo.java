/*Assignment Details: 
 * - Load the url 
 * - https://finance.yahoo.com/ 
 * - Click on “Crypto” tab 
 * - Locate the table in the dom page 
 * - Locate the cryptocurrency names in the table using specific row and column. 
 * - Use loop to iterate the cryptocurrency names 
 * - Print the cryptocurrency names 
 */
package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//creating the ChromeDriver object to launch the browser and inspect the web elements.
		ChromeDriver driver = new ChromeDriver(option);
		//to load the web page "https://finance.yahoo.com/"
		driver.get("https://finance.yahoo.com/");
		//to maximize the browser window
		driver.manage().window().maximize();
		//to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.findElement(By.xpath("//button[text()='Accept all']")).click();
		//to mouse hover on "More" tab
		WebElement eleMore = driver.findElement(By.xpath("//button[@aria-label='More']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(eleMore);
		actions.build().perform();
		//to click on “Crypto” tab
		driver.findElement(By.xpath("//a[@aria-label='Finance: Crypto']")).click();
		//to locate the crypto currency names in the table using specific row and column
		List<WebElement> eleCurrencyNames = driver.findElements(By.xpath(
				"//table/tbody/tr/td[2]/span/div"));		
		System.out.println("Crypto currency names:");
		System.out.println("======================");
		//to iterate the cryptocurrency names list
		for(WebElement element : eleCurrencyNames)
		{
			//to print the crypto currency names
			System.out.println(element.getText());
		}
		//to close the window
		driver.close();
	}

}
