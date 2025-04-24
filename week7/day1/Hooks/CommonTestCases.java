package stepdefinition;

import org.openqa.selenium.By;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonTestCases extends BaseClassLead {
	@When("Enter the username as {string}")
	public void enter_the_username_as(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);
	}
	@And("Enter the password as {string}")
	public void enter_the_password_as(String passWord) {
		driver.findElement(By.id("password")).sendKeys(passWord);
	}
	@And("Click on Login Button")
	public void click_on_login_button() {
		driver.findElement(By.className("decorativeSubmit")).click();
		//driver.switchTo().alert().accept();
	}
	@Then("Homepage is displayed")
	public void homepage_is_displayed() {
	    System.out.println(driver.getTitle());
	}
	@When("Click on crmsfa link")
	public void click_on_crmsfa_link() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@And("Click on the leads link")
	public void click_on_the_leads_link() {
		driver.findElement(By.linkText("Leads")).click();
	}
	@And("Click on Find Leads link")
	public void click_on_find_leads_link() {
		driver.findElement(By.linkText("Find Leads")).click();
	}
}
