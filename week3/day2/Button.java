package week3.day2;

//inheriting from the WebElement class
public class Button extends WebElement {
	public void submit() {
		setText("Button");
		click();
	}
}
