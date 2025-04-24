package base;

import java.time.Duration;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethod {
	public static EdgeDriver driver;
	@BeforeMethod
	public void preCondition() {
		//to instantiate the driver
		driver = new EdgeDriver();
		//to launch the url
		driver.get("http://leaftaps.com/opentaps/");
		//to maximize the window
		driver.manage().window().maximize();
		//to add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	@AfterMethod
	public void postCondition() {	
		//to close the browser window
		driver.close();		
	}
}
