package pages;

import org.openqa.selenium.By;
import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod {	
	//To enter the username
	public LoginPage enterUname() {
		driver.findElement(By.id("username")).sendKeys("demoCSR");
		return this;
	}	
	//To enter the password
	public LoginPage enterPwd() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");		
		return this;		
	}
	//To click on Login button
	public WelcomePage clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();		
		return new WelcomePage();
		
	}

}
