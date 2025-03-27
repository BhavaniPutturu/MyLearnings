/*
 * Assignment Requirements: 
 * - Declare an array for {3, 2, 11, 4, 6, 7} 
 * - Declare another array for {1, 2, 8, 4, 9, 7} 
 * - Compare both the arrays 
 * - Print the values if they are equal
 */
package week4.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FindIntersectionUsingList {
	//Created Scanner object to read the input arrays from the user.
	public static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int array1Size = 0, array2Size = 0;		
		System.out.println("Enter first array size:");		
		array1Size = s.nextInt();		
		//To read the first array elements
		int[] arr1 = getArrayValues(array1Size);		
		System.out.println("Enter second array size:");
		array2Size = s.nextInt();
		//To read the second array elements
		int[] arr2 = getArrayValues(array2Size);
		//using ArrayList --> allows duplicate values
		List<Integer> listArr1 = new ArrayList<Integer>();
		List<Integer> listArr2 = new ArrayList<Integer>();
		//to add array1 values to listArr1
		for(int i=0; i<arr1.length; i++)
			listArr1.add(arr1[i]);
		//to add array2 values to listArr2
		for(int i=0; i<arr2.length; i++)
			listArr2.add(arr2[i]);
		//to print the intersected values
		System.out.println("Intersection values using List:" + 
				findIntersection(listArr1, listArr2));
		//using HashSet --> does not allow duplicate values
		Set<Integer> setArr1 = new HashSet<Integer>();
		Set<Integer> setArr2 = new HashSet<Integer>();	
		//to add array1 values to setArr1
		for(int i=0; i<arr1.length; i++)
			setArr1.add(arr1[i]);
		//to add array2 values to setArr2
		for(int i=0; i<arr2.length; i++)
			setArr2.add(arr2[i]);
		//to print the intersected values
		System.out.println("Intersection values using Set:" + 
				findIntersectionSet(setArr1, setArr2));
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
	//to find the intersected values of two lists
	public static List<Integer> findIntersection(List<Integer> listArr1, List<Integer> listArr2)
	{		
		List<Integer> listIntersection = new ArrayList<Integer>();
		//to iterate each element in listArr1
		for(Integer item: listArr1)
		{
			//to check whether listArr2 contains the current item 
			if(listArr2.contains(item))
			{
				listIntersection.add(item);
			}			
		}
		return listIntersection;
	}
	//to find the intersected values of two sets
	public static Set<Integer> findIntersectionSet(Set<Integer> setArr1, Set<Integer> setArr2)
	{		
		Set<Integer> listIntersection = new HashSet<Integer>();
		//to iterate each element in setArr1
		for(Integer item: setArr1)
		{
			//to check whether setArr2 contains the current item
			if(setArr2.contains(item))
			{
				listIntersection.add(item);
			}			
		}
		return listIntersection;
	}
}
