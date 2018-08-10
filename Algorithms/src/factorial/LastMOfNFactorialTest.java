package factorial;

// is it a cheat???
// 20! = 2*3*4*5*6*7*8*9*10*11*12*13*14*15*16*17*18*19*20 = 
// 2 * 5 * 10 * 15 * 20  * 3*4*6*7*8*9*11*12*13*14*16*17*18*19=
// 30000 * 3*4*6*7*8*9*11*12*13*14*16*17*18*19

// Max O(20)
class MOfNFactorialCheat
{
				
	public String getLastMonNFactorial(int n, int m)
	{
		if (n < 0)
			throw new IllegalArgumentException("N is invalid");
		
		if(m > 4 || m < 0)
			throw new IllegalArgumentException("M is invalid");
				
		if (n >= 20)
			switch(m)
			{	
				case 4:
					return "0000";
				case 3:
					return "000";
				case 2:
					return "00";
				case 1:
					return "0";
			}
	
		if (n >= 15 && m <= 3)
			switch(m)
			{					
				case 3:
					return "000";
				case 2:
					return "00";
				case 1:
					return "0";
			}
	
		if (n >= 10 && m <= 2)
			switch(m)
			{	
				case 2:
					return "00";
				case 1:
					return "0";
			}
		
		if (n >= 5 && m <=1)
			return "0";
				
		return String.format("%d" ,(long) (fact(n) % Math.pow(10, m))); 
	}
	
	public long fact(int n)
	{
		long fact = 1;
		
		for (int i = 2; i <= n; i ++)
			fact *= i;
		
		return fact;
	}
}


public class LastMOfNFactorialTest 
{
	
	public static void main (String[] args)
	{
				
		try {
			MOfNFactorialCheat test = new MOfNFactorialCheat();
			
			for (int n = 2; n < 21; n ++)
				for (int m = 1; m <= 4; m ++)
					System.out.printf("n = %d, m = %d, last m of n! (%d) is %s%n",n , m, test.fact(n), test.getLastMonNFactorial(n, m));
		} 
		
		catch (IllegalArgumentException e){
			System.err.print(e.getLocalizedMessage());
		}
	}
}
