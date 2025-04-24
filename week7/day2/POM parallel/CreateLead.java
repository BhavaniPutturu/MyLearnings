package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import base.ProjectSpecificMethod;

public class CreateLead extends ProjectSpecificMethod{
	//Using constructor to run the test cases in parallel
	public CreateLead(EdgeDriver driver) {
		this.driver = driver;
	}
	//To enter the company name
	public CreateLead enterCompName()
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		return this;
	}
	//To enter first name
	public CreateLead enterFirstName()
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Bhavani");			
		return this;
	}
	//To enter last name
	public CreateLead enterLastName()
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("P");		
		return this;
	}
	//To click on Submit button
	public ViewLeads clickSubmit() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeads(driver);
	}
}
