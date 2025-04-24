package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EditLead extends BaseClassLead {
	@And("Click on the phone tab")
	public void click_the_phone_tab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@And("Enter the phone number to edit (.*)$")
	public void enter_the_phone_number_as(String phno) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phno);
	}
	@And("Click on Find Leads button")
	public void click_on_find_leads_button() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@And("Click on Edit")
	public void click_on_edit() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
	}
	@And("Enter the company name to edit the lead (.*)$")
	public void enter_the_company_name(String cName) {
		WebElement eleCompName = driver.findElement(By.id("updateLeadForm_companyName"));
		eleCompName.clear();
		eleCompName.sendKeys(cName);
	}
	@Then("Click on the submit button")
	public void click_on_the_submit_button() {
		driver.findElement(By.name("submitButton")).click();
	}
}






