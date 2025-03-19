package week3.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrintDuplicates {
	//Created Scanner object to read the input arrays from the user.
	public static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter first array size:");		
		int arraySize = s.nextInt();		
		ArrayList<Integer> dups = findDups(getArrayValues(arraySize));
		System.out.println("Duplicate values are:");
		for(int i=0; i<dups.size(); i++)
		{
			System.out.print(dups.get(i) + " ");
		}
	}
	//To read the input from the user by passing the array size.
	public static int[] getArrayValues(int arrSize)
	{	
		System.out.println("Enter array values:");
		int[] arr = new int[arrSize];
		for(int i=0; i<arrSize;i++)
		{
			arr[i] = s.nextInt();
		}
		return arr;
	}	
	//To get the duplicate elements from the input array
	public static ArrayList<Integer> findDups(int[] arr)
	{
		//to sort the array
		Arrays.sort(arr);
		ArrayList<Integer> dupList = new ArrayList<Integer>();
		for(int i=0; i<arr.length-1; i++)
		{
			//to compare the next element is same as the current value
			//and to check the value is already in duplicate list
			if(arr[i]==arr[i+1] && !dupList.contains(arr[i]))
			{
				dupList.add(arr[i]);			
			}
		}
		return dupList;		
	}
}
