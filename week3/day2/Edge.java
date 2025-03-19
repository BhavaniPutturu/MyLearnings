package week3.day2;

//inheriting from Browser class
public class Edge extends Browser{

	public static void main(String[] args) {
		Edge e = new Edge();		
		e.takeSnap();
		e.clearCookies();
		e.openURL();
		e.navigateBack();
		e.closeBrowser();
		
	}
	public void takeSnap()
	{
		System.out.println("takeSnap--->Edge");
	}
	public void clearCookies()
	{
		System.out.println("clearCookies--->Edge");
	}
}
