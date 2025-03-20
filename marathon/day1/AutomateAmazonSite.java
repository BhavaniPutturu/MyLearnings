/*
TestCase:
---------

01) Launch Chrome  
02) Load https://www.amazon.in/
     add  implicitlyWait
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
03) Type "Bags for boys" in the Search box
04) Choose the item in the result (bags for boys)
05) Print the total number of results (like 50000)
   example like this-----> 1-48 of over 50,000 results for "bags for boys"
06) Select the first 2 brands in the left menu
07) Choose New Arrivals (Sort)
08) Print the first resulting bag info (name, discounted price)
09) Get the page title and close the browser(driver.close())
*/
package marathon.day1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateAmazonSite {

	public static void main(String[] args) {
		//used try and catch blocks for exception handling.
		try {
			//creating the ChromeDriver object to launch the browser and inspect the web elements.
			ChromeDriver driver = new ChromeDriver();
			//to load the web page "https://www.amazon.in/"
			driver.get("https://www.amazon.in/");
			//to maximize the browser window
			driver.manage().window().maximize();
			//to wait upto 10 seconds of every operation
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//to type the text "Bags for boys" in the Search box
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys");
			//to choose the item in the search result "bags for boys"
			driver.findElement(By.xpath("//div[contains(text(),'bags for boys')]")).click();
			//created a string variable, resultText to store the total number of results
			String resultText = driver.findElement(By.xpath("//div[@class='sg-col-inner']/h2/span")).getText();
			resultText += " ";
			resultText += driver.findElement(By.xpath("//div[@class='sg-col-inner']/h2/span[3]")).getText();
			//to print the total number of results on console
			System.out.println(resultText);
			//to select the first brand from the left menu
			driver.findElement(By.xpath("//div[@id='brandsRefinements']/ul/span/span/li/span/a/span")).click();
			//to select the second brand from the left menu			
			driver.findElement(By.xpath("(//div[@id='brandsRefinements']/ul/span/span/li/span/a/span)[2]")).click();
			//to click on Sort by button
			driver.findElement(By.xpath("//span[contains(text(),'Sort by')]")).click();
			//to select 'Newest Arrivals' from Sort by dropdown
			driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
			//created a variable, itemInfo to store the first item information
			String itemInfo = "\nName: ";
			//to add the first item name to the string "itemInfo"
			itemInfo += driver.findElement(By.xpath("//div[@data-cy='title-recipe']/a/h2/span")).getText();
			itemInfo += "\nDiscounted price: ";
			//to add the first item discounted price to the string "itemInfo"
			itemInfo += driver.findElement(By.xpath("//span[@class='a-price-symbol']")).getText();
			itemInfo += driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
			//to print the itemInfo text on console
			System.out.println(itemInfo);
			//to print the current web page title on console
			System.out.println("Current page title: "+driver.getTitle());
			//to close the browser
			driver.quit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
