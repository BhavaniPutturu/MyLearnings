package week3.day2;

//inheriting from the WebElement class
public class TextField extends WebElement {
	public String getText() {
		setText("Text field");
		return webElementText;
	}
}
