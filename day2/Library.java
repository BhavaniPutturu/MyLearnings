package week1.day2;

public class Library {

	public static void main(String[] args) {
		Library lib = new Library();
		System.out.println("Book name: " + lib.addBook("Software Testing"));
		lib.issueBook();
	}
	public String addBook(String bookTitle)
	{
		System.out.println("Book added successfully");
		return bookTitle;
	}
	public void issueBook()
	{
		System.out.println("Book issued successfully");
	}
}
