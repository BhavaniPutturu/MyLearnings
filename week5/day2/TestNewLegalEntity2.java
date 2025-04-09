package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestNewLegalEntity2 extends ProjectSpecificMethod {
	@Test
	public void createNewLegalEntity() throws InterruptedException
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
		//Click on the Dropdown icon in the legal Entities tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//span[contains(text(),'Legal Entities')]/following::lightning-icon")));
		//Click on New Legal Entity
		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//span[text()='New Legal Entity']")));
		//Enter the company name
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		//Enter the description
		driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/textarea")).sendKeys("Salesforces");
		//locate Status dropdown element
		WebElement eleStatus = driver.findElement(By.xpath("//label[text()='Status']/following::button"));
		//Mouse hover to Status dropdown
		actions.moveToElement(eleStatus).perform();
		Thread.sleep(2000);
		//Click on Status dropdown
		driver.executeScript("arguments[0].click()", eleStatus);
		//Select 'Active' from the options
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Active']")).click();
		//Click on save button
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		//Print the missing mandatory field
		String alertMsg = driver.findElement(By.xpath("//ul[contains(@class,'errorsList')]/li/a")).getText();
		System.out.println("Missing mandatory field: " + alertMsg);
	}

}
