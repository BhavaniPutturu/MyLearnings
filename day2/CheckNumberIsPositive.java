package week1.day2;

import java.util.Scanner;

public class CheckNumberIsPositive {

	public static void main(String[] args) {
		try 
		{
			System.out.println("Enter a number:");
			Scanner s = new Scanner(System.in);
			int input = s.nextInt();
			if(input>=0)
				System.out.println("The number you have entered is positive.");
			else
				System.out.println("The number you have entered is negative.");
			s.close();
		}
		catch(Exception e) {
			System.out.println("Invalid input");
		}

	}

}
