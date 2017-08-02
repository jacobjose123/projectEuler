package first26_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacobjose123
 *
 */
public class P34_DigitFactorials {
	
	private static Map<Integer,Integer> factorialMap;
	private static List<Integer> curiousNumbersList;
	
	private static void displayCuriousNumber()
	{
		System.out.println("Curious Numbers List : ");
		
		int i=0;
		for(int curiousNumber: curiousNumbersList)
		{
			System.out.println((++i)+"."+curiousNumber);
		}
	}
	
	private static long findCuriousDigits(int limit)
	{
		long curiousNumbersListSum=0;
//		/*The numbers 1 and 2 are ignored as per the question*/
		for(int i=3;i<=limit;i++)
		{
			
			if(isCurious(i))
			{
				System.out.println(i+"\t\t"+"Curious Number");
				curiousNumbersListSum=curiousNumbersListSum+i;
				curiousNumbersList.add(i);
			}
			else
				System.out.println(i);
		}
		return curiousNumbersListSum;
	}
	
	private static void initializeFactorialMap()
	{
		factorialMap = new HashMap<Integer, Integer>();
		curiousNumbersList = new ArrayList<Integer>();
		
		for(int i=0;i<=9;i++)
		{
			factorialMap.put(i, factorial(i));
		}
	}
	
	private static int factorial(int number)
	{
		if(number==0 || number==1)
			return 1;
		else
		{
			int factorial=1;
			for(int i=1;i<=number;i++)
				factorial*=i;
			
			return factorial;
		}
	}

	private static boolean isCurious(int number)
	{
		char [] digits = String.valueOf(number).toCharArray();
		
		long sum=0;
		
		for(int i=0;i<digits.length;i++)
		{
			
			sum+=factorialMap.get(Character.getNumericValue(digits[i]));
		}
		
		if(sum==number)
			return true;
		else
			return false;
		
	}
	
	public static void main(String[] args) {
		initializeFactorialMap();
		
		System.out.println("Sum of Curious Numbers is : "+findCuriousDigits( (factorial(9)*7) ));
		
		displayCuriousNumber();

	}

}
