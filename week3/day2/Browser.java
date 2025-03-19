package week3.day2;

//Created the super class
public class Browser {
	
	public String browserName, browserVersion;
	public void openURL()
	{
		System.out.println("openURL--->Browser");
	}
	public void closeBrowser()
	{
		System.out.println("closeBrowser--->Browser");
	}
	public void navigateBack()
	{
		System.out.println("navigateBack--->Browser");
	}
}
