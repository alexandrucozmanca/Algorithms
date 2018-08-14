package sorters;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

public class InsertSortListTest
{

	public static void insertSort(List<Integer> data)
	{
		for (int step = 1; step < data.size() ; step ++)
		{	
			Integer insert = data.get(step); // value to insert
			int moveItem = step; // location to place element
			
			// search for place to put current element
			while(moveItem > 0 && data.get(moveItem - 1) > insert)
			{
				// shift element right one slot
				data.set(moveItem, data.get(moveItem - 1));
				moveItem --;
			}
			
			data.set(moveItem, insert);
					
		}
	}
	
	
	
	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		
		List<Integer> data = new LinkedList<>();
		
		for (int i = 0; i < 10; i ++)
			data.add(10 + generator.nextInt(90));
		
			
		System.out.printf("Unsorted array: %n");
		for (int i = 0 ; i < data.size(); i ++)
			System.out.print(data.get(i)+ " ");
		System.out.println();
		System.out.println();
		
		insertSort(data);
		
		System.out.printf("%nSorted array: %n");
		for (int i = 0 ; i < data.size(); i ++)
			System.out.print(data.get(i)+ " ");
		System.out.println();
	}
}
