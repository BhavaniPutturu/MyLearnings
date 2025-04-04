/*Precondition: 
 * - Initialize ChromeDriver 
 * - Load the URL (https://www.amazon.in/) 
 * - Maximize the browser window 
 * - Add an implicit wait to ensure the webpage elements are fully loaded
 *Requirements: 
 * 1. Load the URL (https://www.amazon.in/)
 * 2. Search for "oneplus 9 pro". 
 * 3. Get the price of the first product. 
 * 4. Print the number of customer ratings for the first displayed product. 
 * 5. Click the first text link of the first image. 
 * 6. Take a screenshot of the product displayed. 
 * 7. Click the 'Add to Cart' button. 
 * 8. Get the cart subtotal and verify if it is correct. 
 * 9. Close the browser.
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsAmazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		//to disable the browser notifications
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//creating the ChromeDriver object to launch the browser and inspect the web elements.
		ChromeDriver driver = new ChromeDriver(option);
		//to create the Actions object
		Actions actions = new Actions(driver);
		//to load the url "https://www.amazon.in/"
		driver.get("https://www.amazon.in/");
		//to maximize the browser window
		driver.manage().window().maximize();
		//to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//to enter the text "oneplus 9 pro" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		//to get the price of first product from the search results
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Price of the first product: " + price);
		//to get the ratings icon element
		WebElement eleRating = driver.findElement(By.xpath("//i[@class='a-icon a-icon-popover']"));		
		//to mouse hover on the ratings icon
		actions.moveToElement(eleRating);
		actions.click().build().perform();
		//to print the number of customer ratings for the first displayed product. 
		String noOfRatings = driver.findElement(By.xpath("//span[@data-hook='total-review-count']")).getText();
		System.out.println("Number of ratings: " + noOfRatings);
		//to click on the first image
		driver.findElement(By.xpath("//img[@class='s-image']")).click();
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File("C:\\Users\\krthi\\eclipse-workspace\\Selenium\\src\\main\\resources\\oneplus.png");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		//to get the window handles
		Set<String> windows = driver.getWindowHandles();
		//to convert the Set to List
		List<String> listWindows = new ArrayList<String>(windows);
		//to switch the driver focus to child window
		driver.switchTo().window(listWindows.get(1));
		//to get the "Add to cart" button element
		WebElement eleAdd = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		//to scroll to "Add to cart" button
		actions.moveToElement(eleAdd).perform();
		//to click on the "Add to cart" button
		eleAdd.click();
		//Get the cart sub total and verify if it is correct
		String subTotal = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Cart sub total is: " + subTotal);
		System.out.println("Product price: "+price);
		subTotal=subTotal.substring(1).replace(".00", "");		
		if(price.equals(subTotal))
			System.out.println("Cart sub total is same as the product price.");
		else
			System.out.println("Cart sub total is not same as the product price.");
		driver.quit();
	}

}
