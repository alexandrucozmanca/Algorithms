package anagram;
import java.util.Arrays;
import java.util.HashMap;


// O (n log (n)) datorita sortarii 
class AnagramCheating
{
	private String st1;
	private String st2;

	AnagramCheating(String st1, String st2)
	{
		this.st1 = st1;
		this.st2 = st2;
	}
		
	public boolean isAnagram()
	{
		
		
		
		String testSt1 = trim(st1);
		if(testSt1.length() == 0)
			throw new IllegalArgumentException("String 1 has no non-whiteSpace characters");
		
		String testSt2 = trim(st2);
		
		if(testSt1.length() == 0)
			throw new IllegalArgumentException("String 1 has no non-whiteSpace characters");
		
		if(testSt1.length() != testSt2.length())
			return false;
		
		char[] arraySt1 = testSt1.toLowerCase().toCharArray();
		char[] arraySt2 = testSt2.toLowerCase().toCharArray();
		
		Arrays.sort(arraySt1);
		Arrays.sort(arraySt2);
		
		testSt1 = new String(arraySt1);
		testSt2 = new String(arraySt2);
				
		return (testSt1.equals(testSt2)); 
	}
	
		
	private static String trim(String string)
	{
		string = string.replaceAll("\\s+","");
				
		return string;
	}
		
}

//O(n)
class AnagramHashMap
{
	private String st1;
	private String st2;
	private HashMap<Character, Integer> map = new HashMap<>();

	AnagramHashMap(String st1, String st2)
	{
		this.st1 = st1;
		this.st2 = st2;
	}
	
	public boolean isAnagram()
	{
		String testSt1 = trim(st1);
		if(testSt1.length() == 0)
			throw new IllegalArgumentException("String 1 has no whiteSpace characters");
					
		String testSt2 = trim(st2);
		if(testSt2.length() == 0)
			throw new IllegalArgumentException("String 2 has no whiteSpace characters");
		
		
		if(testSt1.length() != testSt2.length())
			return false;
			
		char[] arraySt1 = testSt1.toLowerCase().toCharArray();
		char[] arraySt2 = testSt2.toLowerCase().toCharArray();
		
		//map testSt1
		for(char a : arraySt1)
		{
			if (map.get(a) == null)
				map.put(a, 1);
			else
				map.put(a, map.get(a) + 1);
		}
		
		// reverse map testSt2
		for (char a : arraySt2)
		{	
			map.put(a, map.get(a) - 1);
			if (map.get(a) < 0)
				return false;
		}
		
		return true;
	}
	
	private static String trim(String string)
	{
		string = string.replaceAll("\\s+","");
				
		return string;
	}
}

public class IsAnagram
{
	
	public static void main (String[] args)
	{
		String STRING1 = "   Ana are mere    ";
		String STRING2 = " erem   era  ana ";
		String STRING3 = " erem       era  ane ";
		String STRING4 = "           ";
		
		
		AnagramCheating test = new AnagramCheating(STRING1, STRING2);
		
		try {
			long startTime = System.nanoTime();
			System.out.println(test.isAnagram());		
			long endTime = System.nanoTime();
			System.out.println((endTime - startTime) +" nanoseconds\n");
		}
		
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getLocalizedMessage());
		}
		
		AnagramHashMap testHash = new AnagramHashMap(STRING1, STRING2);
		
		try {
			long startTime = System.nanoTime();
			System.out.println(testHash.isAnagram());	
			long endTime = System.nanoTime();
			System.out.println((endTime - startTime) +" nanoseconds\n");
		}
		
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getLocalizedMessage());
		}
		
AnagramHashMap testHash1 = new AnagramHashMap(STRING3, STRING4);
		
		try {
			long startTime = System.nanoTime();
			System.out.println(testHash1.isAnagram());	
			long endTime = System.nanoTime();
			System.out.println((endTime - startTime) +" nanoseconds\n");
		}
		
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getLocalizedMessage());
		}
		
	}
	
	
	
}
