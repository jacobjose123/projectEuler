package first26_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacobjose123
 *
 */
public class P30_DigitFifthPower {
	
	private static int power ;
	private static Map<Integer,Integer> powerMap;
	private static List<Integer> terms;
	
	private static void initializeMap(int _power)
	{
		power=_power;
		
		powerMap = new HashMap<Integer, Integer>();
		for(int i=0;i<10;i++)
		{
			powerMap.put(i, (int)Math.pow(i, power));
		}
		
		terms = new ArrayList<Integer>();
	}
	
	private static boolean isANarcissitNumber(int number)
	{
		int sum=0;
		char [] digits = String.valueOf(number).toCharArray();
		for(int i=0;i<digits.length && sum<=number;i++)
		{
			sum+=powerMap.get(Character.getNumericValue(digits[i]));
		}
		
		if(sum==number)
			return true;
		else
			return false;
		
	}
	
	private static long findNarcissitNumberSum()
	{
		long sum=0;
		int startNumber = (int)Math.pow(2, power);
		int endNumber = (int)(Math.pow(9, power)*power);
		
		
		
		for(int i=startNumber;i<=endNumber;i++)
		{
			
			if(isANarcissitNumber(i))
			{
				System.out.println(i+"\t\t\t"+"TRUE");
				sum+=i;
				terms.add(i);
			}
			else
				System.out.println(i);
		}
		
		
		System.out.println("Start Term : "+startNumber);
		System.out.println("End term : "+endNumber);
		return sum;
	}

	private static void displayTerms()
	{
		System.out.println(power+" narcissit numbers are :");
		for(int term:terms)
			System.out.println(term);
		
	}

	public static void main(String[] args) {

		int power = 5;
		
		initializeMap(power);
		
		
		
		System.out.println(" Sum : "+findNarcissitNumberSum());
		
		displayTerms();
	}

}
