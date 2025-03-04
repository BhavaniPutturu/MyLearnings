package week1.day2;

import java.util.Scanner;

public class FindPrimeNumber {

	public static void main(String[] args) {
		try 
		{
			System.out.println("Enter a number:");
			Scanner s = new Scanner(System.in);
			int input = s.nextInt();
			FindPrimeNumber prime = new FindPrimeNumber();
			boolean isPrime = prime.isPrime(input);
			if(isPrime)
				System.out.println("Given input is a prime number.");
			else
				System.out.println("Given input is not a prime number.");
			s.close();
		}
		catch(Exception e) {
			System.out.println("Invalid input");
		}

	}
	
	public boolean isPrime(int input)
	{
		boolean isPrime = true;
		for(int div=2;div<input;div++)
		{
			if(input%div == 0)
			{
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
