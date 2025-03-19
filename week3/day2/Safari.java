package week3.day2;

//inheriting from Browser class
public class Safari extends Browser {

	public static void main(String[] args) {
		
		Safari s= new Safari();
		s.readerMode();
		s.fullScreenMode();
		s.openURL();
		s.navigateBack();
		s.closeBrowser();
	}
	public void readerMode()
	{
		System.out.println("readerMode--->Safari");
	}
	public void fullScreenMode()
	{
		System.out.println("fullScreenMode--->Safari");
	}

}
