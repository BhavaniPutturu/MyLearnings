package week1.day2;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		try 
		{
			System.out.println("Enter the range:");
			Scanner s = new Scanner(System.in);
			int range = s.nextInt();
			FibonacciSeries fib = new FibonacciSeries();
			fib.PrintFibonacciSeries(range);
			s.close();
		}
		catch(Exception e) {
			System.out.println("Invalid input");
		}

	}
	public void PrintFibonacciSeries(int range)
	{
		int firstNum = 0;
		int secondNum = 1;
		System.out.print(firstNum);
		System.out.print("," + secondNum);
		for(int i=3; i<=range; i++)
		{
			int nextNum = firstNum + secondNum;
			System.out.print("," + nextNum);
			firstNum = secondNum;
			secondNum = nextNum;
		}
	}

}
