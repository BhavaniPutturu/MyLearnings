package week3.day1;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the first string: ");
		//To get the first string from the user
		String str1 = s.next();
		System.out.println("Enter the second string: ");
		//To get the second string from the user
		String str2 = s.next();
		//Check whether the input strings lengths are equal
		if(str1.length() == str2.length())
		{
			char[] input1 = str1.toCharArray();
			char[] input2 = str2.toCharArray();
			//To sort the input strings
			Arrays.sort(input1);
			Arrays.sort(input2);
			//To convert the char[] to string and			
			//to check the values of strings are equal by using equals() method.
			if(String.valueOf(input1).equals(String.valueOf(input2)))
				System.out.println("The given strings are Anagram.");
			else
				System.out.println("The given strings are not Anagram.");
		}			
		else
			System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
		
		s.close();
	}

}
