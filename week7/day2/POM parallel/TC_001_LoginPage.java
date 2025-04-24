package testcases;

import org.testng.annotations.Test;
import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC_001_LoginPage extends ProjectSpecificMethod {
	@Test
	public void runLogin() {
		LoginPage login = new LoginPage(driver);
		//using method chaining to create the lead
		login.enterUname().enterPwd().clickLogin();
	}
}
