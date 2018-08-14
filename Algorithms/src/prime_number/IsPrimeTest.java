package prime_number;

class IsPrime
{
	int n;
	
	IsPrime(int n)
	{
		this.n = n;
	}
	
	//O(sqrt N)
	public boolean isPrime()
	{
		for (int i = 2; i < Math.sqrt(n); i ++)
			if (n % i == 0)
				return false;
			
		return true;
	}


}

public class IsPrimeTest 
{
	public static void main(String[] args)
	{
		int NUMBER1 = 5;
		int NUMBER2 = 2242;
		int NUMBER3 = 4327;
		
		IsPrime test1 = new IsPrime(NUMBER1);
		System.out.printf("Number %d %s a prime.%n", NUMBER1, test1.isPrime() == true ? "is"  : "is not");
		
		IsPrime test2 = new IsPrime(NUMBER2);
		System.out.printf("Number %d %s a prime.%n", NUMBER2, test2.isPrime() == true ? "is"  : "is not");
		
		IsPrime test3 = new IsPrime(NUMBER3);
		System.out.printf("Number %d %s a prime.%n", NUMBER3, test3.isPrime() == true ? "is"  : "is not");
	}
}
