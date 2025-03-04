package week1.day2;

public class EdgeBrowser {

	public static void main(String[] args) {
		Browser browser = new Browser();
		System.out.println("Browser name is: " + browser.launchBrowser("Edge"));
		browser.loadUrl();
	}
}