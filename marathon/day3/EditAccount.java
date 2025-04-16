package marathon.day3;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditAccount extends BaseClassOpportunity {
	//used to groups to handle the depends on group for delete opportunity account
	@Test(dataProvider = "fetchData",
			groups={"EditAccount.editOpportunity"},
			dependsOnGroups={"CreateAccount.createOpportunity"})
    public void editOpportunity(String OppName, String desc) throws InterruptedException {
        //Click on the toggle menu button
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        //Click on "View All"
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        //select "Sales" from the App Launcher
        driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Click on the "Opportunity" tab
        js.executeScript("arguments[0].click();", 
        		driver.findElement(By.xpath("//span[text()='Opportunities']")));        
        //Search for the Opportunity
        driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(
        		OppName, Keys.ENTER);
        Thread.sleep(3000);
        //Click on the Dropdown icon
        driver.findElement(By.xpath("//table/tbody/tr/td[8]/span/div/a")).click();
        //select 'Edit'
        driver.findElement(By.xpath("//a[@title='Edit']")).click();
        //Choose the close date
        driver.findElement(By.xpath("//label[text()='Close Date']/following::input")).click();        
        driver.findElement(By.xpath("//span[text()='18']")).click();      
        driver.findElement(By.xpath("//label[text()='Stage']/following::button")).click();
        Thread.sleep(2000);
        //Select 'Stage' as 'Perception Analysis'
        driver.findElement(By.xpath("//label[text()='Stage']/following::span[text()='Perception Analysis']")).click();
        Thread.sleep(5000);
        WebElement eleDelInstall = driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following::button"));
        Actions action = new Actions(driver);
        action.scrollToElement(eleDelInstall);
        action.build().perform();
        driver.executeScript("arguments[0].click();", eleDelInstall);
        //Select 'Delivery/Installation Status' as 'In Progress'
        driver.findElement(By.xpath("//span[text()='In progress']")).click();    
        //Enter Description as 'SalesForce'
        driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys(desc);
        //Click on 'Save'
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        Thread.sleep(2000);
        String strStage = driver.findElement(By.xpath("//table/tbody/tr/td[5]/span/span")).getText();
        String strSelectedStage = "Perception Analysis";
        //verify the Stage as 'Perception Analysis'
        if(strStage.equals(strSelectedStage))
        	System.out.println("Verification of stage is success");
        else
        	System.out.println("Verification of stage is failed");
    }
	@BeforeTest
	public void setValues()
	{
		//to specify the excel file name and sheet index
		fileName="Opportunity";
		index = 1;
	}
}
