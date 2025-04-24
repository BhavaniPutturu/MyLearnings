package testcases;

import org.testng.annotations.Test;
import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC_003_CreateAccount extends ProjectSpecificMethod {	
	@Test
	public void runCreateLead() {
		LoginPage login = new LoginPage(driver);
		//using method chaining to create the lead
		login.enterUname().enterPwd().clickLogin().clickCrmsfaLink().clickLeads().
			clickCreateLead().enterCompName().enterFirstName().enterLastName().clickSubmit().verifyLeads();
	}
}
