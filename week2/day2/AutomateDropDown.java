package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateDropDown {

	public static void main(String[] args){
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		System.out.println("Title: " + driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();	
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Bhavani");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Putturu");
		WebElement sourceDD = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select selSourceDD = new Select(sourceDD);
		selSourceDD.selectByIndex(4);
		WebElement marketingDD = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select selMarketingDD = new Select(marketingDD);
		selMarketingDD.selectByVisibleText("Automobile");
		WebElement ownerShipDD = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select selOwnerShipDD = new Select(ownerShipDD);
		selOwnerShipDD.selectByValue("OWN_CCORP");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Current webpageTitle: "+ driver.getTitle());
	}

}
