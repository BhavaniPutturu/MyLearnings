package stepdefinition;

import org.openqa.selenium.By;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends BaseClassLead{	

	@And("Click on the createlead link")
	public void click_on_the_createlead_link() {
		driver.findElement(By.linkText("Create Lead")).click();
	} 
	@And("Enter the company name to create lead (.*)$")
	public void enter_the_company_name(String cName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	}
	@And("Enter the firstname as (.*)$")
	public void enter_the_firstname(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}
	@And("Enter the lastname as (.*)$")
	public void enter_the_lastname(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	}
	@And("Enter the phone number as (.*)$")
	public void enter_the_phone_number_as(String phno) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
	}
	@Then("Click on the leads submit button")
	public void click_on_the_leads_submit_button() {
		driver.findElement(By.name("submitButton")).click();
	}
}






