package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRadioButton {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[text()='Firefox']/parent::td/div/div[2]")).click();
		String chnXpath = "//label[text()='Chennai']/parent::div/div/div[2]";
		driver.findElement(By.xpath(chnXpath)).click();
		String str = driver.findElement(By.xpath(chnXpath)).getDomAttribute("class");
		System.out.println("Chennai radio button is selected: "+ str.contains("ui-state-active"));
		driver.findElement(By.xpath(chnXpath)).click();
		str = driver.findElement(By.xpath(chnXpath)).getDomAttribute("class");
		System.out.println("Chennai radio button is selected: "+ str.contains("ui-state-active"));
		defaultButtonCheck(driver);
		selectAgeRadioButton(driver);
	}
	
	//To identify the radio button that is initially selected by default.
	public static void defaultButtonCheck(ChromeDriver driver)
	{
		List<WebElement> defaultCheckRadionButtons = driver.findElements(By.xpath(
				"//h5[text()='Find the default select radio button']/following-sibling::div/div/table/tbody/tr/td"));
		for(WebElement ele : defaultCheckRadionButtons)
		{
			WebElement ele1 = ele.findElement(By.xpath(".//div/div[2]"));
			if(ele1.getAttribute("class").contains("ui-state-active"))
			{
				System.out.print("Initially selected Radio button name is: ");
				String name = ele.findElement(By.xpath(".//label")).getText();
				System.out.println(name);
				break;
			}
		}
		
	}
	
	//To check and select the age group (21-40 Years) if not already selected.
	public static void selectAgeRadioButton(ChromeDriver driver)
	{
		List<WebElement> ageRadioButtons = driver.findElements(By.xpath("//h5[text()='Select the age group (only if not selected)']/following-sibling::div/div/div/div/div/div/div[2]"));
		for(WebElement ele : ageRadioButtons)
		{
			String name = ele.findElement(By.xpath(".//parent::div/following-sibling::label")).getText();
			if(name.equals("21-40 Years"))
			{
				if(!ele.getAttribute("class").contains("ui-state-active"))
				{
					ele.click();
					System.out.println("Selecting 21-40 Years radio button.");
				}				
				else
					System.out.println("21-40 Years radio button is already selected.");			
			}
		}
	}

}
