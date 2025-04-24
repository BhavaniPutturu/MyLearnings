package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import base.ProjectSpecificMethod;

public class WelcomePage extends ProjectSpecificMethod {
	public WelcomePage(EdgeDriver driver) {
		this.driver = driver;
	}
	//To click on CRM/SFA link
	public HomePage clickCrmsfaLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new HomePage(driver);
	}
	//To click on Logout button
	public LoginPage clickLogout() {
		driver.findElement(By.xpath("//input[@value='Logout']")).click();
		return new LoginPage(driver);
	}
}
