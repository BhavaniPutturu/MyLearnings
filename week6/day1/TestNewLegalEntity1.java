package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestNewLegalEntity1 extends ProjectSpecificMethod {
	@Test(dataProvider = "fetchData")
	public void createBasicLegalEntity(String name) throws InterruptedException
	{
		//Click on the toggle menu button from the left corner		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click View All from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		//Click on Legal Entities 
		WebElement eleLegalEntities = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		Actions actions = new Actions(driver);
		//to scroll to the Legal Entities
		actions.scrollToElement(eleLegalEntities);		
		actions.build().perform();
		eleLegalEntities.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		//Click on the Dropdown icon in the legal Entities tab
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(
			"//span[contains(text(),'Legal Entities')]/following::lightning-icon")));
		//Click on New Legal Entity
		js.executeScript("arguments[0].click();", 
				driver.findElement(By.xpath("//span[text()='New Legal Entity']")));
		//String legalEntityName = "Salesforce Automation by Bhavani";
		//Enter Name as 'Salesforce Automation by Bhavani'
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		//Click on save button
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		//verify Legal Entity Name
		String displayLegalEntityName = driver.findElement(
				By.xpath("//slot[@name='outputField']/lightning-formatted-text")).getText();
		if(name.equals(displayLegalEntityName))
			System.out.println("Verification success");
		else
			System.out.println("Verification failed");
	}
}
