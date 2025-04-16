package marathon.day3;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteAccount extends BaseClassOpportunity{
	@Test(dataProvider = "fetchData",
			dependsOnGroups={"EditAccount.editOpportunity"})
    public void deleteOpportunity(String OppName) throws InterruptedException {        
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
        		"Salesforce Automation by Bhavani", Keys.ENTER);
        Thread.sleep(3000);
        //Click on the Dropdown icon
        driver.findElement(By.xpath("//table/tbody/tr/td[8]/span/div/a")).click();
        //select 'Delete'
        driver.findElement(By.xpath("//a[@title='Delete']")).click();
        //click on delete from popup
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        //Verify whether the Opportunity is deleted using the Opportunity
        driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(
        		OppName, Keys.ENTER);
        try {
        	driver.findElement(By.xpath("//table/tbody/tr")).click();
        	System.out.println("Opprtunity is not deleted");
        }
        catch(Exception e) {
        	System.out.println("Opprtunity is deleted");
        }
    }
	@BeforeTest
	public void setValues()
	{
		fileName="Opportunity";
		index = 2;
	}

}
