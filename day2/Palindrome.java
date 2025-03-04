package week1.day2;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		try {
			System.out.println("Enter a number:");
			Scanner s = new Scanner(System.in);
			long input = s.nextLong();		
			Palindrome palin = new Palindrome();
			long output = palin.getReverseNumber(input);
			if(output == input)
				System.out.println("It is a Palindrome (because the number reads the same backward and forward)");
			else
				System.out.println("It is not a Palindrome (since the reversed number, " +
						output + ", is not the same as original)");
			s.close();
		}
		catch(Exception e) {
			System.out.println("Invalid input");
		}
	}
	
	public long getReverseNumber(long num)
	{
		long rev;
		for(rev=0; num>0; num/=10)
		{
			rev=(rev*10) + (num%10);
		}
		
		return rev;
	}

}
