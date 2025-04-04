package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LearnWebTable {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//creating the ChromeDriver object to launch the browser and inspect the web elements.
		ChromeDriver driver = new ChromeDriver(option);
		//to open the given url in chrome browser
		driver.get("https://erail.in/");
		driver.findElement(By.xpath("//p[text()='Consent']")).click();
		//to maximise the browser window
		driver.manage().window().maximize();
		//to wait till 30 seconds of every operation
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement eleFrom = driver.findElement(By.id("txtStationFrom"));
		eleFrom.clear();
		eleFrom.sendKeys("MAS", Keys.ENTER);
		WebElement eleTo = driver.findElement(By.id("txtStationTo"));
		eleTo.clear();
		eleTo.sendKeys("MDU", Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> listTrain = driver.findElements(By.xpath(
				"//table[contains(@class,'TrainList')]/tbody/tr/td[2]"));
		System.out.println("Available trains:");
		System.out.println("------------------");
		for(WebElement name: listTrain)
			System.out.println(name.getText());
		
	}

}
