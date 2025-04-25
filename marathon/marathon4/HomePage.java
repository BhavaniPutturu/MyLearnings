package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	public HomePage clickToggleMenu() {
		click(locateElement(Locators.XPATH, "//div[@class='slds-icon-waffle']"));
		reportStep("Toggle menu is clicked successfully", "pass");	
		return this;
	}
	public HomePage clickViewAll() {		
		click(locateElement(Locators.XPATH, "//button[text()='View All']"));
		reportStep("ViewAll link is clicked successfully", "pass");		
		return this;
	}
	public IndividualsPage clickIndividuals() throws InterruptedException {
		scrollToElement(locateElement(Locators.XPATH, "//p[text()='Individuals']"));
		pause(3000);
		clickUsingJs(locateElement(Locators.XPATH, "//p[text()='Individuals']"));
		reportStep("Individuals link is clicked successfully", "pass");
		return new IndividualsPage();
	}
	
}
