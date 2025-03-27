package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindSecondLargest {
	//Created Scanner object to read the input arrays from the user.
	public static Scanner s = new Scanner(System.in);
		
	public static void main(String[] args) {
		int arraySize = 0;		
		System.out.println("Enter first array size:");		
		arraySize = s.nextInt();		
		//to read the list values
		List<Integer> list = getArrayValues(arraySize);
		//to sort the list
		Collections.sort(list);
		//to print the second largest value of the list
		System.out.println("The second largest value of the list is " + list.get(arraySize-2));
	}
	//To read the input from the user by passing the array size.
	public static List<Integer> getArrayValues(int arrSize)
	{	
		System.out.println("Enter array values:");
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<arrSize;i++)
		{
			//to add the input value to the list
			list.add(s.nextInt());
		}
		return list;
	}
}
