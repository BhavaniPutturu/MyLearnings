package marathon.day3;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccount extends BaseClassOpportunity{
	//used to groups to handle the depends on group for edit opportunity account
	@Test(dataProvider = "fetchData", groups= {"CreateAccount.createOpportunity"})
    public void createOpportunity(String OppName, String amount) throws InterruptedException {
		//Click on the toggle menu button in the left corner.
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        //Click on "View All"
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        Thread.sleep(2000);
        WebElement eleOpp = driver.findElement(By.xpath("//p[text()='Opportunities']"));
        Actions actions = new Actions(driver);		
		actions.scrollToElement(eleOpp);		
		actions.build().perform();
		//select "Sales" from the App Launcher
		eleOpp.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Opportunities')]/following::a"));
        //Click on the "Opportunity" tab
        ele.click();
        Thread.sleep(3000);
        //Click on the "New" button
        ele = driver.findElement(By.xpath("//span[text()='New Opportunity']"));
        		js.executeScript("arguments[0].click();",ele);
        //Enter the Opportunity name
        		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input")).sendKeys(OppName);
        //Enter Amount
        driver.findElement(By.xpath("//label[text()='Amount']/following::input")).sendKeys(amount);
        //Choose the close date
        driver.findElement(By.xpath("//label[text()='Close Date']/following::input")).click();        
        driver.findElement(By.xpath("//button[text()='Today']")).click();
        //Select 'Stage' as 'Need Analysis
        driver.findElement(By.xpath("//label[text()='Stage']/following::button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Stage']/following::span[text()='Needs Analysis']")).click();
        //Click on the 'Save' button
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String strOppName = driver.findElement(By.xpath("//lightning-formatted-text")).getText();
        //verify the Opportunity Name
        if(strOppName.equals(OppName))
        	System.out.println("Verification of opportutnity name is success");
        else
        	System.out.println("Verification of opportutnity name is failed");
    }
	@BeforeTest
	public void setValues()
	{
		//to specify the excel file name and sheet index
		fileName="Opportunity";
		index = 0;
	}

}
