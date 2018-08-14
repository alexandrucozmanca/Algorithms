package recursion;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class IterativePermutationTest 
{
	private static void swap(int[] vector,int index1, int index2)
	{
		int temp = vector[index1];
		vector[index1] = vector[index2];
		vector[index2] = temp;
	}
	
	private static ArrayList<ArrayList<Integer>> permutation(int[] vector)
	{		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		result.add(new ArrayList<Integer>());
		
		for(int i = 0; i < vector.length; i ++)
		{
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> arrayList : result)
			{
				for(int j = 0; i < arrayList.size() + 1; j ++)
				{
					
				}
			}
		}
		
		
		return result;
	}
	
	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		int SIZE = 2 + generator.nextInt(9);
					
		int[] vector = new int[SIZE];
		
		for (int i = 0; i < vector.length; i ++)
			vector[i] = 10 + generator.nextInt(90);
			
		
		permutation(vector);
	}

}
