/*
 * Assignment Requirements: 
 *  -Declare a String array and add the values as {HCL, Wipro, Aspire Systems, CTS} 
 *  -Add the collection to a list 
 *  -Iterate the values in the list 
 *  -Print the required output as Wipro, HCL, CTS, Aspire Systems
 */
package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingList {

	public static void main(String[] args) {
		//to initialize an array of strings
		String[] names = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		//to declare the list
		List<String> listNames = new ArrayList<String>();
		//to add the array elements to list
		for(int i=0; i<names.length; i++)
			listNames.add(names[i]);
		//to sort the list
		Collections.sort(listNames);
		System.out.println("The reversed list:");
		//to print the list values in reverse order
		for(int i=listNames.size()-1; i>=0; i--)
			System.out.println(listNames.get(i));
	}

}
