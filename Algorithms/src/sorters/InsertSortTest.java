package sorters;

import java.security.SecureRandom;
import java.util.Arrays;

public class InsertSortTest
{

	public static void insertSort(int[] data)
	{
		for (int step = 1; step < data.length ; step ++)
		{	
			int insert = data[step]; // value to insert
			int moveItem = step; // location to place element
			
			// search for place to put current element
			while(moveItem > 0 && data[moveItem - 1] > insert)
			{
				// shift element right one slot
				data[moveItem] = data[moveItem - 1];
				moveItem --;
			}
			
			data[moveItem] = insert;
			
			printPass(data, step);
		}
	}
	
	public static void printPass(int[] data, int step)
	{
		for (int i = 0; i < data.length; i ++)
		{
			if (i == step)
				System.out.print("*");
			
			System.out.print(data[i] + " ");
		}
		
		System.out.println();
	}
	
	
	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		
		int[] data = new int[10];
		
		for (int i = 0; i < data.length; i ++)
			data[i] = 10 + generator.nextInt(90);
		
		System.out.printf("Unsorted array: %n%s%n%n", Arrays.toString(data));
		insertSort(data);
		
		System.out.printf("Sorted array: %n%s%n%n", Arrays.toString(data));
		
	}
}
