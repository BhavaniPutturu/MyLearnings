package week3.day1;

import java.util.Scanner;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the first string: ");
		//To get the input from user
		String input = s.next();
		
		//Converting all the characters into lower case letters and then to char array
		char[] inputArr = (input.toLowerCase()).toCharArray();
		System.out.println("The output after changing the odd index value to upper case:");
		for(int i=0; i<inputArr.length; i++)
		{
			//if the index is odd, printing that particular element as upper case letter
			if(i%2 == 1)
				System.out.print(Character.toUpperCase(inputArr[i]));
			else
				System.out.print(inputArr[i]);
		}
		s.close();
	}

}
