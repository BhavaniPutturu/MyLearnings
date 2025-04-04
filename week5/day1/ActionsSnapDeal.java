/*Requirements: 
 * 1. Launch (https://www.snapdeal.com/) 
 * 2. Go to "Men's Fashion". 
 * 3. Go to "Sports Shoes". 
 * 4. Get the count of sports shoes. 
 * 5. Click on "Training Shoes". 
 * 6. Sort the products by "Low to High".
 * 7. Check if the displayed items are sorted correctly. 
 * 8. Select any price range ex:(500-700). 
 * 9. Filter by any colour. 
 * 10. Verify all the applied filters. 
 * 11. Mouse hover on the first resulting "Training Shoes". 
 * 12. Click the "Quick View" button. 
 * 13. Print the cost and the discount percentage. 
 * 14. Take a snapshot of the shoes. 
 * 15. Close the current window. 
 * 16. Close the main window. 
 */
package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsSnapDeal {
	private static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		//to disable the browser notifications
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//creating the ChromeDriver object to launch the browser and inspect the web elements.
		driver = new ChromeDriver(option);
		//to load the web page "https://www.snapdeal.com/"
		driver.get("https://www.snapdeal.com/");
		//to maximize the browser window
		driver.manage().window().maximize();
		//to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//to mouse hover on "Men's Fashion".
		WebElement eleMensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(eleMensFashion);
		actions.build().perform();
		//to click on 'Sports Shoes'
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		//to print the count of sports shoes		
		String strCount = driver.findElement(By.xpath(
				"//span[contains(@class,'category-count')]")).getText();
		System.out.println("Number of items: " + strCount);
		//to click on "Training Shoes". 
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		//to sort the products by "Low to High".
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();	
		Thread.sleep(5000);
		//to prices of the displayed items 
		List<WebElement> listPriceElements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		verifyPriceList(listPriceElements);
		//to select the starting price
		WebElement eleFrom = driver.findElement(By.xpath("//input[@name='fromVal']"));
		eleFrom.clear();
		eleFrom.sendKeys("500");
		//to select the ending price
		WebElement eleTo = driver.findElement(By.xpath("//input[@name='toVal']"));
		eleTo.clear();
		eleTo.sendKeys("700", Keys.ENTER);
		Thread.sleep(10000);
		//to select the colour
		WebElement eleColour = driver.findElement(By.xpath(
				"//a[contains(text(),'White & Blue')]/parent::label"));
		actions.scrollToElement(eleColour);
		actions.build().perform();
		eleColour.click();
		verifyFilters();
		//to mouse hover on the first product
		WebElement eleFirstProduct = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		actions.moveToElement(eleFirstProduct);
		actions.build().perform();
		//to click on Quick view
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		//to print the price of the first product
		String strPrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Price: Rs."+strPrice);
		//to print the discount percentage
		String strDiscount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount percentage:"+strDiscount);
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File("C:\\Users\\krthi\\eclipse-workspace\\Selenium\\src\\main\\resources\\Shoes.png");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		//to close all the opened windows
		//driver.quit();
	}
	//To verify the prices are in sorted order
	public static void verifyPriceList(List<WebElement> listPriceElements)
	{
		List<Integer> listPrice = new ArrayList<Integer>();		
		for(WebElement element : listPriceElements)
		{
			String price = element.getText();
			price = price.replace(" ", "");
			price = price.replace("Rs.", "");
			price = price.replace(",", "");
			listPrice.add(Integer.parseInt(price));
		}
		System.out.println(listPrice);
		List<Integer> sortedList = new ArrayList<Integer>(listPrice);
		Collections.sort(sortedList);
		System.out.println("Sorted list:");
		System.out.println(sortedList);
		if(listPrice.equals(sortedList))
			System.out.println("Prices are in sorted order");
		else
			System.out.println("Prices are not in sorted order");		
	}
	//To verify all the applied filters
	public static void verifyFilters()
	{
		String strPriceRange = driver.findElement(By.xpath("//a[@data-key='Price|Price']")).getText();
		if(strPriceRange.contains("500") && strPriceRange.contains("700"))
			System.out.println("Displaying the selected price range.");
		else
			System.out.println("Not displaying the selected price range.");
		String strColour = driver.findElement(By.xpath("//a[@data-key='Color_s|Color']")).getText();
		if(strColour.contains("White & Blue"))
			System.out.println("Displaying the selected colour products.");
		else
			System.out.println("Not displaying the selected colour products.");
		
	}

}
