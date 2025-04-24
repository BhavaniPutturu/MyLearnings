package pages;

import org.openqa.selenium.By;
import base.ProjectSpecificMethod;

public class MyLeadsPage extends ProjectSpecificMethod {
	//To click on Create Lead
	public CreateLead clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLead();
	}
}
