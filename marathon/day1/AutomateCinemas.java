package marathon.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateCinemas {
	public static void main(String[] args) {
		//used try and catch blocks for exception handling.
		try {
			//creating the ChromeDriver object to launch the browser and inspect the web elements.
			ChromeDriver driver = new ChromeDriver();
			//to load the web page "https://www.cineworld.co.uk/#/"
			driver.get("https://www.cineworld.co.uk/#/");
			//to maximize the browser window
			driver.manage().window().maximize();
			//to wait upto 30 seconds of every operation
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//to accept the cookies settings
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
			//to select the theatre
			driver.findElement(By.xpath("//span[contains(text(),'Select my cinema')]")).click();
			//to select the first theatre near by my location
			driver.findElement(By.xpath("//div[@class='row cinemas-list']/div[2]/a/div/div/p/img")).click();
			//to select the show for tomorrow
			driver.findElement(By.xpath("//button[@data-automation-id='day_1']")).click();
			//to click on "Choose a screening type" button
			driver.findElement(By.xpath("//span[text()='Choose a screening type']")).click();
			//to select the "Comedy" from the options
			driver.findElement(By.xpath("//li/a/span[contains(text(),'Comedy')]")).click();
			//to click on "Choose a film" button
			driver.findElement(By.xpath("//span[text()='Choose a film']")).click();
			//to select the first displayed movie
			driver.findElement(By.xpath("(//li[@data-original-index='2'])[3]")).click();
			//to click on timing of the show
			driver.findElement(By.xpath("//div[@class='qb-movie-info-column']/a[1]")).click();
			//to close the browser
			driver.quit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
