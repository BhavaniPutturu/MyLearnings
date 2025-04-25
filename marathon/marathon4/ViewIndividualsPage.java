package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ViewIndividualsPage extends ProjectSpecificMethods {	
	public ViewIndividualsPage verifyIndividualsName(String lName) {
		verifyExactText(locateElement(Locators.XPATH,"//span[@class='uiOutputText']"), lName);
		reportStep(lName+" is matching with last name", "pass");
		return this;
	}
	

	
	
}
