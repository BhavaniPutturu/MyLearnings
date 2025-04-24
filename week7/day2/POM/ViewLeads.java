package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethod;

public class ViewLeads extends ProjectSpecificMethod {
	//To verify the name that has been created
	public ViewLeads verifyLeads(){
		String name = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(name.equals("Bhavani"))
			System.out.println("Name is matched");
		else
			System.out.println("Name is not matched");
		return this;
	}
	
}
