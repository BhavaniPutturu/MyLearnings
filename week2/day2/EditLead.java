package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		System.out.println("Title: " + driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		createLead(driver);
		editLead(driver);
		System.out.println(driver.getTitle());
	}
	//Method to create the lead 
	public static void createLead(ChromeDriver driver)
	{
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//td/input[@name='companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//td/input[@name='firstName']")).sendKeys("Bhavani");
		driver.findElement(By.xpath("//td/input[@name='lastName']")).sendKeys("Putturu");
		driver.findElement(By.xpath("//td/input[@name='firstNameLocal']")).sendKeys("Bhavani P");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Automation Testing");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("bhavanicsuk@gmail.com");
		Select stateDD = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		stateDD.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
	}
	//Method to edit lead information
	public static void editLead(ChromeDriver driver)
	{
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Selenium with java");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
	}
}
