package palindrome;

class Palindrome 
{
	String st;
	
	Palindrome(String string)
	{
		st = string;
	}
		
	private static String trim(String string)
	{
		string = string.replaceAll("\\s+","");
				
		return string;
	}
	// O(n)
	public boolean isPalindrome()
	{
		String testSt = trim(st);
		if(st.length() == 0)
			throw new IllegalArgumentException("String has no non-whiteSpace characters");
	
		 testSt = testSt.toLowerCase();
		
		for (int i = 0; i < testSt.length() / 2 ; i ++)
			if (testSt.charAt(i) != testSt.charAt(testSt.length() - 1 - i))
				return false;
		
		return true;
	}
}


public class PalindromeTest 
{	
	public static void main(String[] args)
	{
		String TEST1 = "Adda";
	
		Palindrome test1 = new Palindrome(TEST1);
		System.out.printf("String %s %s a palindrome.%n", TEST1, test1.isPalindrome() == true ? "is"  : "is not");
		
		String TEST2 = "Addam";
		
		Palindrome test2 = new Palindrome(TEST2);
		System.out.printf("String %s %s a palindrome.%n", TEST2, test2.isPalindrome() == true ? "is"  : "is not");
		
		String TEST3 = "Adc m c da";
		
		Palindrome test3 = new Palindrome(TEST3);
		System.out.printf("String %s %s a palindrome.%n", TEST3, test3.isPalindrome() == true ? "is"  : "is not");
		
	}

}
