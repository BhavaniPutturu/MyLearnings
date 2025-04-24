package pages;
import org.openqa.selenium.By;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod {
	//To click on Leads link
	public MyLeadsPage clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeadsPage();
	}
}
