package week3.day2;

//created the super class named WebElement
public class WebElement {
	public String webElementText="";
	public void click() {
		System.out.println("Clicked on " + webElementText);
	}
	public void setText(String text) {
		webElementText = text;
		System.out.println("Assigned the text '" + webElementText + "' to class variable.");
	}
}
