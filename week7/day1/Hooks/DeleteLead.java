package stepdefinition;

import org.openqa.selenium.By;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DeleteLead extends BaseClassLead {
	private String leadID;
	@And("Enter the phone number to delete (.*)$")
	public void enter_the_phone_number_as(String phno) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phno);
	}
	@And("Click on Delete")
	public void click_on_delete() throws InterruptedException {
		Thread.sleep(3000);
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();
	}
	@Then("verify the deleted lead")
	public void verify_the_deleted_lead() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}
}






