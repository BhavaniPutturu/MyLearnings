package week3.day2;

//inheriting from TestData class
public class LoginTestData extends TestData {

	public static void main(String[] args) {
		LoginTestData obj = new LoginTestData();
		obj.enterCredentials();		
		obj.enterUsername();
		obj.enterPassword();
		obj.navigateToHomePage();
	}
	
	public void enterUsername() {
		System.out.println("Calling enterUsername() method from subclass.");
	}

	public void enterPassword() {
		System.out.println("Calling enterPassword() method from subclass.");		
	}
}
