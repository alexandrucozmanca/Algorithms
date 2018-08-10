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
		st1 = trim(st1);
		if(st1.length() == 0)
			throw new IllegalArgumentException("String 1 has no whiteSpace characters");
		
		st2 = trim(st2);
		
		if(st1.length() == 0)
			throw new IllegalArgumentException("String 1 has no whiteSpace characters");
		
		if(st1.length() != st2.length())
			return false;
		
		char[] arraySt1 = st1.toLowerCase().toCharArray();
		char[] arraySt2 = st2.toLowerCase().toCharArray();
		
		Arrays.sort(arraySt1);
		Arrays.sort(arraySt2);
		
		st1 = new String(arraySt1);
		st2 = new String(arraySt2);
				
		return (st1.equals(st2)); 
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
		st1 = trim(st1);
		if(st1.length() == 0)
			throw new IllegalArgumentException("String 1 has no whiteSpace characters");
					
		st2 = trim(st2);
		
		if(st1.length() == 0)
			throw new IllegalArgumentException("String 1 has no whiteSpace characters");
		
		
		if(st1.length() != st2.length())
			return false;
			
		char[] arraySt1 = st1.toLowerCase().toCharArray();
		char[] arraySt2 = st2.toLowerCase().toCharArray();
		
		//map st1
		for(char a : arraySt1)
		{
			if (map.get(a) == null)
				map.put(a, 1);
			else
				map.put(a, map.get(a) + 1);
		}
		
		// reverse map st2
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
		String STRING3 = " erem   era  ane ";
		
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
		
	}
	
	
	
}
