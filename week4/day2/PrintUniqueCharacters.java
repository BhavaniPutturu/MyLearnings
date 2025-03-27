/*
 *  Assignment Requirements: 
 *  - You are provided with a string variable: companyName = "google"
 *  - Create a Set to store unique characters. 
 *  - Iterate through each character in the companyName string. 
 *  - Add each character into the Set. 
 *  - Print the unique characters from the string.
 */
package week4.day2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrintUniqueCharacters {

	public static void main(String[] args) {
		//Created Scanner object to read the input arrays from the user.
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the input string:");
		//to read the input from the user
		String input = s.nextLine();
		//to convert the input string to lower case
		input = input.toLowerCase();
		//to remove the white spaces
		input = input.replace(" ", "");
		//Set declaration
		Set<Character> setInput = new HashSet<Character>();
		//to add the input characters to set, which allows only unique values
		for(int i=0; i<input.length(); i++)
			setInput.add(input.charAt(i));
		//to print the unique characters
		System.out.println("Unque characters in the input string are:" + setInput);
		//to close the scanner object
		s.close();
	}

}
