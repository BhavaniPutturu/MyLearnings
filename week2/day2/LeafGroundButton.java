package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundButton {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(
			"//h5[text()='Click and Confirm title.']/following-sibling::button/span[text()='Click']")).click();
		System.out.println("Current webpage title: " + driver.getTitle());
		driver.navigate().back();
		System.out.println("Disable button status: " + driver.findElement(By.xpath(
				"//h5[text()='Confirm if the button is disabled.']/following-sibling::button")).isEnabled());
		System.out.print("Find the position of Submit button's position: ");
		System.out.println(driver.findElement(By.xpath(
			"//h5[text()='Find the position of the Submit button']/following-sibling::button")).getLocation());
		System.out.print("Background color of Save button: ");
		System.out.println(driver.findElement(By.xpath(
				"//h5[text()='Find the Save button color']/following-sibling::button")).getCssValue("background-color"));
		System.out.print("Find the height and width of this button's size: ");
		System.out.println(driver.findElement(By.xpath(
				"//h5[text()='Find the height and width of this button']/following-sibling::button")).getSize());
		driver.close();
	}

}
