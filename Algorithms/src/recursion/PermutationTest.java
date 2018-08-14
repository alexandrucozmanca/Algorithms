package recursion;

import java.security.SecureRandom;
import java.util.Arrays;

public class PermutationTest 
{
	private static void swap(int[] vector,int index1, int index2)
	{
		int temp = vector[index1];
		vector[index1] = vector[index2];
		vector[index2] = temp;
	}
	
	private static void permutation(int[] vector, int index)
	{
		if(index == vector.length - 1)
			System.out.println(Arrays.toString(vector));
		
		for(int i = index; i < vector.length; i ++)
		{
			swap(vector, index, i);
			permutation(vector, index + 1);
			swap(vector, index, i);
		}
	}
	
	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		int SIZE = 2 + generator.nextInt(9);
					
		int[] vector = new int[SIZE];
		
		for (int i = 0; i < vector.length; i ++)
			vector[i] = 10 + generator.nextInt(90);
			
		
		permutation(vector, 0);
	}

}
