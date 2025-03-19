package week3.day2;

//inheriting from Browser class
public class Chrome extends Browser{

	public static void main(String[] args) {
		
		Chrome c=new Chrome();
		c.openIncognito();
		c.clearCache();
		c.openURL();
		c.navigateBack();
		c.closeBrowser();
	} 
	public void openIncognito()
	{
		 System.out.println("openIncognito--->Chrome");
	}
	public void clearCache()
	{
		System.out.println("clearCache--->Chrome");
	}
}
