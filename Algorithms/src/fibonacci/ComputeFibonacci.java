package fibonacci;
import java.util.ArrayList;

public class ComputeFibonacci 
{	
	static ArrayList<Integer> fibList = new ArrayList<Integer>(10);
	
	
	public static void main(String[] args)
	{
		int RECURSIVE = 9;
		int ITERATIVE = 9;
		int MULTIPLE = 10;
	
		try {
		
			long startTime = System.nanoTime();
			System.out.println("Recursive fibbonaci of (" + RECURSIVE + ") is: " + fibonacciRec(RECURSIVE));
			long endTime = System.nanoTime();
			System.out.println((endTime - startTime) +" nanoseconds\n");
			
			System.out.println("Interative fibbonaci of (" + ITERATIVE + ") is: " + fibonacciIter(ITERATIVE));
			System.out.println();
			
			
			initData(); 
			
			System.out.println("Fibbonaci(" + MULTIPLE + ") with fibonacifibonacciMultiple() method is " + 
					fibonacciMultiple(MULTIPLE)); // O(N)
			System.out.println();
			
			System.out.println("Fibbonaci(" + (MULTIPLE - 1) + ") with fibonacifibonacciMultiple() method is " + 
					fibonacciMultiple(MULTIPLE - 1 ));  // O(1)
			System.out.println();
			
			System.out.println("Fibbonaci(" + (MULTIPLE + 2) + ") with fibonacifibonacciMultiple() method is " + 
					fibonacciMultiple(MULTIPLE + 2));// O(N-M) unde m este marimea ArrayList precalculat
			System.out.println();
			
			System.out.println("Fibbonaci(" + (MULTIPLE + 5) + ") with fibonacifibonacciMultiple() method is " + 
					fibonacciMultiple(MULTIPLE + 5));// O(N-M) unde m este marimea ArrayList precalculat
			System.out.println();
			
			System.out.println("Fibbonaci(" + (MULTIPLE + 4) + ") with fibonacifibonacciMultiple() method is " + 
					fibonacciMultiple(MULTIPLE + 4));// O(N-M) unde m este marimea ArrayList precalculat
			System.out.println();
		
			System.out.println("Interative fibbonaci of (" + (MULTIPLE + 4) + ") is: " + fibonacciIter(MULTIPLE + 4));
			System.out.println();
		
		}
		
		catch(IllegalArgumentException e)
		{
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	// O(n!)
	public static long fibonacciRec(int n)
	{				
		if(n < 0)
			throw new IllegalArgumentException ("N must be positive");
		
		if(n == 0)
			return 0;
		
		if(n == 1)
			return 1;
		
		return fibonacciRec(n-1) + fibonacciRec(n-2);
	}
	
	// O(n) 
	public static long fibonacciIter(int n)
	{
		if(n < 0)
			throw new IllegalArgumentException ("N must be positive");
		
		if (n == 0)
			return 0;
		
		if (n == 1)
			return 1;
		
		long startTime = System.nanoTime();
		
		long temp1 = 1, temp2;
		long fib = 1;
		
		for (int i = 2; i < n ; i ++)
		{	
			temp2 = temp1;
			temp1 = fib;
			
			fib = temp2 + temp1; 
		}
		
		long endTime = System.nanoTime();
		
		System.out.println((endTime - startTime) +" nanoseconds");
		
		return fib;
	}
		 
	
	//O(1) daca n a fost deja calculat O(M-N) daca n nu a fost precalculat
	// pentru situatii cand se solicita mai multe raspunsuri succesive
	public static long fibonacciMultiple(int n)
	{	
		if(n < 0)
			throw new IllegalArgumentException ("N must be positive");
		
		long startTime = System.nanoTime();
		
		if(n < fibList.size())
		{
			long endTime = System.nanoTime();
			System.out.println((endTime - startTime) +" nanoseconds");
			return fibList.get(n);
		}
		
		else
			for (int i = fibList.size(); i <= n; i++)
				fibList.add(fibList.get(i - 1) + fibList.get(i - 2));
							
		
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime)  +" nanoseconds");
		return fibList.get(n);
	}
	
	static void initData()
	{
		fibList.add(0);
		fibList.add(1);
		
	}
	
}
