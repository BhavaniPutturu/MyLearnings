package pages;

import org.openqa.selenium.By;
import base.ProjectSpecificMethod;

public class WelcomePage extends ProjectSpecificMethod {
	//To click on CRM/SFA link
	public HomePage clickCrmsfaLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new HomePage();
	}
}
