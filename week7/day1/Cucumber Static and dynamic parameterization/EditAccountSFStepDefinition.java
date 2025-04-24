package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EditAccountSFStepDefinition extends BaseClassSF{
	@And("Click on Accounts link")
	public void click_on_accounts_link() throws InterruptedException {
		Thread.sleep(3000);
        WebElement eleAcc = driver.findElement(By.xpath("//p[text()='Accounts']"));
		actions.scrollToElement(eleAcc);		
		actions.build().perform();
		eleAcc.click(); 
	}
	@And("Search for the account using {string}")
	public void search_for_the_account_using(String accountName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(
        		accountName + Keys.ENTER);
        Thread.sleep(5000);
	}
	@And("Click the dropdown icon next to the account and select Edit")
	public void click_the_dropdown_icon_next_to_the_account_and_select_edit() {
		WebElement eleEditlink = driver.findElement(By.xpath(
	        	"//table/tbody/tr/td[6]/span/div/a"));    
	        actions.scrollToElement(eleEditlink);
	        actions.build().perform();
	        eleEditlink.click();       
	        driver.findElement(By.xpath("//a[@title='Edit']")).click();
	}
	@And("Enter a unique number in the Phone field {string}")
	public void enter_a_unique_number_in_the_phone_field_parameterized_value(String phNo) {
	       WebElement elePhNo = driver.findElement(By.xpath("//label[text()='Phone']/following::input"));
	       elePhNo.clear();
	       elePhNo.sendKeys(phNo);
	}
	@And("Set Type to Technology Partner")
	public void set_type_to_technology_partner() throws InterruptedException {
		driver.findElement(By.xpath("//label[text()='Type']/following::button")).click();
        driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();
        Thread.sleep(5000);
	}
	@And("Set Industry to Healthcare")
	public void set_industry_to_healthcare() throws InterruptedException {
	     WebElement eleInd = driver.findElement(By.xpath("//label[text()='Industry']/following::button"));
	     actions.scrollToElement(eleInd);
	     actions.build().perform();
	     driver.executeScript("arguments[0].click();", eleInd);
	     Thread.sleep(2000);
	     WebElement eleHealthCare = driver.findElement(By.xpath("//span[text()='Healthcare']"));
	     actions.scrollToElement(eleHealthCare);
	     actions.build().perform();
	     eleHealthCare.click();
	}
	@And("Enter the Billing Street {string}")
	public void enter_the_billing_street(String string) {
		driver.findElement(By.xpath(
        		"//label[text()='Billing Street']/following::textarea")).sendKeys("street1");
	}
	@And("Enter the Billing City {string}")
	public void enter_the_billing_city(String string) {
		driver.findElement(By.xpath(
        		"//label[text()='Billing City']/following::input")).sendKeys("city1");
	}
	@And("Enter the Billing Postal Code {string}")
	public void enter_the_billing_zip_postal_code(String string) {
		driver.findElement(By.xpath(
        		"//label[text()='Billing Zip/Postal Code']/following::input")).sendKeys("postcode1");
	}
	@And("Enter the Billing state {string}")
	public void enter_the_billing_state(String string) {
		driver.findElement(By.xpath(
        		"//label[text()='Billing State/Province']/following::input")).sendKeys("state1");
	}
	@And("Enter the Billing country {string}")
	public void enter_the_billing_country(String string) {
		driver.findElement(By.xpath(
        		"//label[text()='Billing Country']/following::input")).sendKeys("country1");
	}
	@And("Enter the Shipping Street {string}")
	public void enter_the_shipping_street(String string) {
		driver.findElement(By.xpath(
        		"//label[text()='Shipping Street']/following::textarea")).sendKeys("street2");
	}
	@And("Enter the Shipping City {string}")
	public void enter_the_shipping_city(String string) {
		driver.findElement(By.xpath(
        		"//label[text()='Shipping City']/following::input")).sendKeys("city2");
	}
	@And("Enter the Shipping Postal Code {string}")
	public void enter_the_shipping_zip_postal_code(String string) {
		driver.findElement(By.xpath(
        		"//label[text()='Shipping Zip/Postal Code']/following::input")).sendKeys("postcode2");
	}
	@And("Enter the Shipping state {string}")
	public void enter_the_shipping_state(String string) {
		driver.findElement(By.xpath(
        		"//label[text()='Shipping State/Province']/following::input")).sendKeys("state2");
	}
	@And("Enter the Shipping country {string}")
	public void enter_the_shipping_country(String string) {
		driver.findElement(By.xpath(
        		"//label[text()='Shipping Country']/following::input")).sendKeys("country2");
	}
	@And("Set Customer Priority to Low")
	public void set_customer_priority_to_low() {
		 driver.findElement(By.xpath("//label[text()='Customer Priority']/following::button")).click();
		 driver.findElement(By.xpath("//span[text()='Low']")).click();
	}
	@And("Set SLA to Silver")
	public void set_sla_to_silver() {
		driver.findElement(By.xpath("//label[text()='SLA']/following::button")).click();
        driver.findElement(By.xpath("//span[text()='Silver']")).click();
	}
	@And("Set Active to NO")
	public void set_active_to_no() throws InterruptedException {
		  WebElement eleActive =  driver.findElement(By.xpath("//label[text()='Active']/following::button"));
	        actions.scrollToElement(eleActive);
	        actions.build().perform();
	        driver.executeScript("arguments[0].click();", eleActive);
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//span[text()='No']")).click();
	}
	@And("Set Upsell Opportunity to No")
	public void set_upsell_opportunity_to_no() throws InterruptedException {
		WebElement eleUpsell =  driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following::button"));
        actions.scrollToElement(eleUpsell);
        actions.build().perform();
        driver.executeScript("arguments[0].click();", eleUpsell);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='No']")).click();
	}
	@Then("Verify the phone number")
	public void verify_the_phone_number() {
		String strPhNo = driver.findElement(By.xpath("//table/tbody/tr/td[4]/span/span")).getText();        
        System.out.println(strPhNo);
	}
}
