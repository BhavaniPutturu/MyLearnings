package week2.day2;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args){
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-inner'])[2]")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("8754224336");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		List<WebElement> records = driver.findElements(By.xpath("//td/div/a[@class='linktext']"));
		if(records.size()>0)
		{
			String leadId = records.get(0).getText();
			records.get(0).click();
			driver.findElement(By.className("subMenuButtonDangerous")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			String msg = driver.findElement(By.className("x-paging-info")).getText();
			System.out.println(msg);			
		}
		
	}

}
