package week3.day1;

import java.util.Scanner;

public class FindIntersection {
	//Created Scanner object to read the input arrays from the user.
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		int array1Size = 0, array2Size = 0;	
		
		System.out.println("Enter first array size:");		
		array1Size = s.nextInt();		
		int[] array1 = getArrayValues(array1Size);//To read the first array elements
		
		System.out.println("Enter second array size:");
		array2Size = s.nextInt();
		int[] array2 = getArrayValues(array2Size);//To read the second array elements
		
		printIntersection(array1, array2);
		
		s.close();
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
	
	//To print the intersection values of given two arrays.
	public static void printIntersection(int[] firstArray, int[] secondArray) 
	{
		System.out.println("Intersected values of given arrays:");
		
		//outer loop is to get each element from the first array to compare	
		for(int i=0; i<firstArray.length; i++)		
		{	
			//inner loop is to print the matching value of second array 
			for(int j=0; j<secondArray.length; j++)
			{
				if(firstArray[i] == secondArray[j])
				{
					System.out.println(secondArray[j]);
					break;
				}
			}
		}		
	}
}
