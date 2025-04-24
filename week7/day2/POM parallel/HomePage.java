package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod {
	//Using constructor to run the test cases in parallel
	public HomePage(EdgeDriver driver) {
		this.driver = driver;
	}

	//To click on Leads link
	public MyLeadsPage clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeadsPage(driver);
	}
}
