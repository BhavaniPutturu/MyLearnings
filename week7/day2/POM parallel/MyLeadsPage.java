package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import base.ProjectSpecificMethod;

public class MyLeadsPage extends ProjectSpecificMethod {
	//Using constructor to run the test cases in parallel
	public MyLeadsPage(EdgeDriver driver) {
		this.driver = driver;
	}
	//To click on Create Lead
	public CreateLead clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLead(driver);
	}
}
