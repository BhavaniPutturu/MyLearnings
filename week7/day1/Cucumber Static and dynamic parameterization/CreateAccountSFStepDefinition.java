package stepdefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateAccountSFStepDefinition extends BaseClassSF{
	
	public String accName;
	@Given("Launch the Browser and Load the SF url")
	public void launch_the_browser_and_load_the_url() {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://login.salesforce.com/");
	}
	@When("Enter the SF username as {string}")
	public void enter_the_username_as(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);
	}
	@And("Enter the SF password as {string}")
	public void enter_the_password_as(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	@And("Click on SF Login Button")
	public void click_on_login_button() {
		driver.findElement(By.id("Login")).click();
	}
	@And("SF Homepage is displayed")
	public void homepage_is_displayed() {
	    System.out.println("Title: " + driver.getTitle());
	}
	@And("Click on toggle menu button from the left corner")
	public void click_on_toggle_menu_button_from_the_left_corner() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}
	@And("Click on view All link")
	public void click_on_view_all_link() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	@And("click on Sales from App Launcher")
	public void click_on_sales_from_app_launcher() {
		driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
	}
	@And("Click on Accounts tab")
	public void click_on_accounts_tab() {
		driver.findElement(By.xpath("//span[text()='Accounts']/following::lightning-primitive-icon")).click();
	}
	@And("Click on New button")
	public void click_on_new_button() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement eleNew = driver.findElement(By.xpath("//span[text()='New Account']"));
        js.executeScript("arguments[0].click();", eleNew);
	}
	@And("Enter account name as (.*)$")
	public void enter_account_name_as(String name) {
		this.accName = name; 
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(name);
	}
	@And("Select Ownership as Public")
	public void select_ownership_as_public() {
		driver.findElement(By.xpath("//label[text()='Ownership']/following::button")).click();
        WebElement elePublic = driver.findElement(By.xpath("//label[text()='Ownership']/following::button/following::lightning-base-combobox-item[2]"));
        Actions action = new Actions(driver);
        action.scrollToElement(elePublic);
        action.build().perform();
        elePublic.click();
	}
	@And("Click on Save button")
	public void click_on_save_button() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}
	@Then("Verify account name")
	public void verifyAccountName() {
		String strAccName = driver.findElement(By.xpath(
			"//records-entity-label[text()='Account']/following::lightning-formatted-text")).getText();
		if(this.accName.equals(strAccName))
			System.out.println("Verification of account name is success");
		else
			System.out.println("Verification of account name is failed");
		}
}
