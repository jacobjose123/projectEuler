package first25;

import java.math.BigInteger;

/**
 * @author jacobjose123
 *
 */
public class P25_First1000DigitFibonacciNumber {
	
	private static boolean isHavingSpecifiedDigits(int digitCount,BigInteger number)
	{
		String numberString = String.valueOf(number);
		if(numberString.length()>=digitCount)
			return true;
		else
			return false;
	}
	
	private static void findDigitIndex(int digitCount)
	{
		BigInteger first = new BigInteger("1");
		BigInteger second = new BigInteger("1");
	
		System.out.println("1. 1");
		System.out.println("2. 1");
		
		int i=2;
		
	
		while(!(isHavingSpecifiedDigits(digitCount, second)) )
		{
			BigInteger secondInitialValue = second; 
			second = second.add(first);
			first= secondInitialValue;
			
			i++;
			System.out.println(i+". "+second);
					
		}
		
		System.out.println("Index of Digit having "+digitCount+" is : "+i);
		
		
	}

	public static void main(String[] args) {

		findDigitIndex(1000);
	}

}
