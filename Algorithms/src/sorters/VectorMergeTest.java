package sorters;

import java.security.SecureRandom;
import java.util.Arrays;

class VectorMerge
{
	int[] vector1;
	int[] vector2;
	int[] outputVector;
	
	VectorMerge(int[] vector1, int[] vector2)
	{
		this.vector1 = vector1;
		this.vector2 = vector2;
		
		outputVector = new int[vector1.length + vector2.length];
	}
	//O(N + M)
	public int[] merge()
	{
		int index1 = 0;
		int index2 = 0;
		int outputIndex = 0;
		
		while(index1 < vector1.length && index2 < vector2.length)
		{
			if(vector1[index1] < vector2[index2])
				outputVector[outputIndex++] = vector1[index1++];
			else	
				outputVector[outputIndex++] = vector2[index2++];
		}	
		
		while(index1 < vector1.length)
			outputVector[outputIndex++] = vector1[index1++];
		
		while(index2 < vector2.length)
			outputVector[outputIndex++] = vector2[index2++];
			
		
		return outputVector;
	}
}


public class VectorMergeTest 
{
	public static void main(String[] args)	
	{
		SecureRandom generator = new SecureRandom();
		int SIZE_VECTOR1 = 1 + generator.nextInt(10);
		int SIZE_VECTOR2 = 1 + generator.nextInt(10);
				
		int[] vector1 = new int[SIZE_VECTOR1];
		int[] vector2 = new int[SIZE_VECTOR2];
 					
		for (int i = 0; i < vector1.length; i ++)
			vector1[i] = 10 + generator.nextInt(90);
 			
		for (int i = 0; i < vector2.length; i ++)
			vector2[i] = 10 + generator.nextInt(90);
		
		Arrays.sort(vector1);
		Arrays.sort(vector2);
		
		VectorMerge test = new VectorMerge(vector1, vector2);
		
		
		System.out.println("Vector1 is: " + Arrays.toString(vector1));
		System.out.println("Vector2 is: " + Arrays.toString(vector2));
		System.out.println("Merged vector is: " + Arrays.toString(test.merge()));
	}
	
}
