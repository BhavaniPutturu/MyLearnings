/*
 * Assignment Requirements:
 *  - Launch the URL https://www.ajio.com/ 
 *  - In the search box, type as "bags" and press enter 
 *  - To the left of screen under "Gender" click on "Men" 
 *  - the screen under "Gender" click on "Men" 
 *  - Under "Category" click "Fashion Bags" 
 *  - Print the count of the items found. 
 *  - Get the list of brand of the products displayed in the page and print the list. 
 *  - Get the list of names of the bags and print it
 */
package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateAmazonList {

	public static void main(String[] args) {
		//creating the ChromeDriver object to launch the browser and inspect the web elements.
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.co.uk/");
		//to maximize the browser window
		driver.manage().window().maximize();
		//to wait upto 10 seconds of every operation
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//to locate the search box and enter "bags" and press enter
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags", Keys.ENTER);
		//to click on "Men" on the left of the screen under "Gender"
		driver.findElement(By.xpath("//div[@id='gender']/ul/span/span/li/span/a/span[text()='Men']")).click();
		//to click on "Popular Brands"
		driver.findElement(By.xpath("//span[text()='Popular Brands']")).click();
		//to get the list of items that are found in the results
		List<WebElement> items = driver.findElements(By.xpath("//div[@data-cy='title-recipe']"));
		//to print the count of the items found
		System.out.println("Number of items : " + items.size());
		//calling the method to print the brand and names of the items
		printResults(items);
	}
	//To print the brand and names of the items from the list
	public static void printResults(List<WebElement> items)
	{
		//loop to iterate each item from the list
		for(WebElement item: items) {
			//to locate the brand element
			WebElement brand = item.findElement(By.xpath("./div[@class='a-row a-size-base a-color-secondary']/h2/span"));
			//to locate the name element
			WebElement name = item.findElement(By.xpath("./a/h2/span"));
			System.out.println("------------------------------------------------");			
			System.out.println(brand.getText());
			System.out.println(name.getText());		
		}
	}

}
