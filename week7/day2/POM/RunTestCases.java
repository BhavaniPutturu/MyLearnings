package testcases;

import org.testng.annotations.Test;
import base.ProjectSpecificMethod;
import pages.LoginPage;

public class RunTestCases extends ProjectSpecificMethod {	
	@Test
	public void runTestCases() {
		LoginPage login = new LoginPage();
		//using method chaining to create the lead
		login.enterUname().enterPwd().clickLogin().clickCrmsfaLink().clickLeads().
			clickCreateLead().enterCompName().enterFirstName().enterLastName().clickSubmit().verifyLeads();
	}
}
