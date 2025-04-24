package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import base.ProjectSpecificMethod;

public class ViewLeads extends ProjectSpecificMethod {
	//Using constructor to run the test cases in parallel
	public ViewLeads(EdgeDriver driver) {
		this.driver = driver;
	}

	public ViewLeads verifyLeads(){		
		String name = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(name.equals("Bhavani"))
			System.out.println("Name is matched");
		else
			System.out.println("Name is not matched");
		return this;
	}
	
}
