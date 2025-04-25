package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class IndividualsPage  extends ProjectSpecificMethods{
	public IndividualsPage clickDropdownIndividuals() throws InterruptedException {
		pause(3000);
		clickUsingJs(locateElement(Locators.XPATH, "//span[contains(text(),'Individuals')]/following::a"));
		reportStep("Dropdown Individuals is clicked successfully", "pass");	
		return this;
	} 
	public IndividualsPage clickNewIndividual() throws InterruptedException {
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='New Individual']"));		
		reportStep("New Individual is clicked successfully", "pass");	
		return this;
	} 
	public IndividualsPage enterLastName(String lName) {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Last Name']"),lName);	
		reportStep(lName + " Last name is entered successfully", "pass");		
		return this;
	}
	public ViewIndividualsPage clickSave() {
		click(locateElement(Locators.XPATH, "//button[@title='Save']"));
		reportStep("Save is clicked successfully", "pass");	
		return new ViewIndividualsPage();
	}
	public IndividualsPage clickIndividualsTab() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[contains(text(),'Individuals')]"));
		reportStep("Individuals Tab is clicked successfully", "pass");	
		return this;
	}
	public IndividualsPage enterLastNameToDelete(String lName) {
		typeAndEnter(locateElement(Locators.XPATH, "//input[@name='Individual-search-input']"), lName);
		reportStep("Last name entered in search box successfully", "pass");	
		return this;
	}
	public IndividualsPage clickDropdownToDelete() throws InterruptedException {
		pause(3000);
		click(locateElement(Locators.XPATH, "//table/tbody/tr/td[6]/span/div/a"));
		reportStep("clicked on Dropdown to Delete successfully", "pass");	
		return this;
	}
	public IndividualsPage clickDelete(){
		click(locateElement(Locators.XPATH, "//a[@title='Delete']"));
		reportStep("clicked on Delete option successfully", "pass");	
		return this;
	}
	public IndividualsPage clickPopupDelete(){
		click(locateElement(Locators.XPATH, "//span[text()='Delete']"));
		reportStep("clicked on Delete in popup window successfully", "pass");	
		return this;
	}
	public IndividualsPage verifyDeletedIndividual() throws InterruptedException {
		pause(5000);
		verifyPartialText(locateElement(Locators.XPATH, 
				"//span[@class='countSortedByFilteredBy']"), "0 items");
		reportStep("Deleted the individual successfully", "pass");
		return this;
	}
}
