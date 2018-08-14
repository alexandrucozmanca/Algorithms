package prime_number;

import java.util.ArrayList;

class PrimeFinder
{
	int n;
	boolean[] primes; 
	
	PrimeFinder(int n)
	{
		if (n > 1000)
			throw new IllegalArgumentException("N must be smaller that 1000");
		
		this.n = n;
		primes= new boolean[n];
	}
	// O(N)
	public int[] getPrimes()
	{
		ArrayList<Integer> primeArray = new ArrayList<>();
		
		for(int i = 2 ; i < n ; i ++)
		{
			if(primes[i] == false)
			{
				primeArray.add(i);
				for(int j = i * i ; j < n; j += i)
				{
					primes[j] = true;
					System.out.print(j + " ");
				}
				
				System.out.println();
			}
		}
				
		int[] primeVector = new int[primeArray.size()];
		for (int i = 0; i < primeVector.length; i ++)
			primeVector[i] = primeArray.get(i);
		
		return primeVector;
	}	
}

public class PrimeVector 
{
	public static void main(String [] args)
	{
		PrimeFinder test1 = new PrimeFinder(990);
		
		int[] primes = test1.getPrimes();
		
		for(int i = 0; i < primes.length; i ++)
		{
			if (i > 0 && i % 20 == 0 )
				System.out.println();
			System.out.printf("%3d ", primes[i]);
		}
		
	}
}
