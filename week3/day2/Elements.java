package week3.day2;

//inheriting from the Button class
public class Elements extends Button {

	public static void main(String[] args) {
		Button btn = new Button();
		TextField tf = new TextField();
		CheckBoxButton cb = new CheckBoxButton();
		RadioButton rb = new RadioButton();
		btn.submit();
		tf.getText();
		cb.clickCheckButton();
		rb.selectRadioButton();
	}

}
