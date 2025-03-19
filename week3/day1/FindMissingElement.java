package week3.day1;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		
		int[] input = {1,4,3,2,8,6,7};
		//To sort the elements in ascending order
		Arrays.sort(input);
		for(int i=0;i<input.length;i++)
		{
			int num = i+1;
			//to check the value of array with the index+1
			if((i+1)!=input[i])
			{
				System.out.println("Missing number is:" + num);
				break;
			}
		}
	}

}
