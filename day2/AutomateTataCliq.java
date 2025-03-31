/* Tatacliq Testcase:
   ==================
1. Load the url as https://www.tatacliq.com/
2. Search 'watch for women'
3. print the result 
4. Select sortby: New Arrivals
5. choose women from categories filter.
6. print all price of watches
7. print the url address
8. close the window
*/
package marathon.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AutomateTataCliq {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//creating the ChromeDriver object to launch the browser and inspect the web elements.
		ChromeDriver driver = new ChromeDriver(option);
		//to open the given url in chrome browser
		driver.get("https://www.tatacliq.com/");
		//to maximise the browser window
		driver.manage().window().maximize();
		//to wait till 30 seconds of every operation
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//to enter "watches for" in search field
		driver.findElement(By.id("search-text-input")).sendKeys("watches for");
		//to wait for search results
		Thread.sleep(2000);
		//to click on watches for women option
		driver.findElement(By.className("SearchResultItem__bolder")).click();
		//to print the result including the items count
		WebElement result = driver.findElement(By.className("Plp__plpHeading"));
		System.out.println(result.getText());
		//to locate and select "New Arrivals" from sortby dropdown
		WebElement sortDD = driver.findElement(By.className("SelectBoxDesktop__hideSelect"));
		Select selSortDD = new Select(sortDD);
		selSortDD.selectByVisibleText("New Arrivals");
		//to choose women from categories filter
		driver.findElement(By.xpath("//div[text()='Women']/preceding-sibling::div")).click();
		//to get and print all watches price list
		List<WebElement> listPrices = driver.findElements(By.xpath("//div[@class='ProductDescription__discount ProductDescription__priceHolder']/h3[@class='ProductDescription__boldText']"));
		System.out.println("Prices of watches:");
		for(WebElement price: listPrices)
			System.out.println(price.getText());
		//to print the url of the current page
		System.out.println("Url: "+ driver.getCurrentUrl());
		//to close the browser
		driver.quit();
	}

}
