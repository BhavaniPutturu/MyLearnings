package week1.day2;

import java.io.IOException;

public class LibraryManagement {

	public static void main(String[] args) throws IOException {
		Library lib = new Library();
		System.out.println("Book name: " + lib.addBook("Software Testing"));
		lib.issueBook();
	}
}
