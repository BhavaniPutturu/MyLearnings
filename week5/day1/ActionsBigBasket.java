/*Requirements:
1. Navigate to https://www.bigbasket.com/.
2. Click on "Shop by Category".
3. Mouse over "Foodgrains, Oil & Masala".
4. Mouse over "Rice & Rice Products".
5. Click on "Boiled & Steam Rice".
6. Filter the results by selecting the brand "bb Royal".
7. Click on "Tamil Ponni Boiled Rice".
8. Select the 5 Kg bag.
9. Check and note the price of the rice.
10. Click "Add" to add the bag to your cart.
11. Verify the success message that confirms the item was added to your cart.
12. Take a snapshot of the current page
13. Close the current window.
14. Close the main window.
 * 
 */
package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsBigBasket {

	public static void main(String[] args) throws InterruptedException, IOException {
		//to disable the browser notifications
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//creating the ChromeDriver object to launch the browser and inspect the web elements.
		ChromeDriver driver = new ChromeDriver(option);
		//to load the web page "https://www.bigbasket.com/"
		driver.get("https://www.bigbasket.com/");
		//to maximize the browser window
		driver.manage().window().maximize();
		//to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//to click on "Shop by Category"
		driver.findElement(By.xpath("(//span[text()='Shop by'])[2]")).click();
		//to locate "Foodgrains, Oil & Masala" element
		WebElement eleFood = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		//creating Actions object
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		//to mouse hover on "Foodgrains, Oil & Masala" element
		action.moveToElement(eleFood);
		action.build().perform();
		//to locate "Rice & Rice Products" element
		WebElement eleRice = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		//to mouse hover on "Rice & Rice Products" element
		action.moveToElement(eleRice);
		action.build().perform();
		//to click on "Boiled & Steam Rice"
		driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
		//to locate the brand "bb Royal"
		WebElement eleBBRoyal = driver.findElement(By.id("i-BBRoyal"));
		//to scroll to the "bb Royal"
		action.scrollToElement(eleBBRoyal);
		action.build().perform();
		//to click on "bb Royal"
		eleBBRoyal.click();
		//to locate the "Tamil Ponni Boiled Rice" element
		WebElement eleTamilPonniRice = driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice - 12 - 17 Months Old']"));
		//to scroll to "Tamil Ponni Boiled Rice" element
		action.scrollToElement(eleTamilPonniRice);
		action.build().perform();
		//to click on Tamil Ponni Boiled Rice element
		eleTamilPonniRice.click();
		//to get the window handles
		Set<String> windows = driver.getWindowHandles();
		//to convert Set to List
		List<String> listWindows = new ArrayList<String>(windows);
		//to switch driver focus to the child window
		driver.switchTo().window(listWindows.get(1));
		Thread.sleep(3000);
		//to locate the element 5kg
		WebElement ele5KG = driver.findElement(By.xpath("//span[text()='5 kg']"));		
		//to scroll to the element 5kg
		action.scrollToElement(ele5KG);		
		action.build().perform();
		//to click on 5Kg option
		ele5KG.click();
		//to get and print the price of 5kg rice bag
		String strPrice = driver.findElement(By.xpath("//table/tr/td")).getText();
		System.out.println("Price of 5 kg rice bag is " + strPrice);
		//to click on "Add to basket" button
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File("C:\\Users\\krthi\\eclipse-workspace\\Selenium\\src\\main\\resources\\Rice.png");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		//to close all the opened windows
		driver.quit();
	}

}
