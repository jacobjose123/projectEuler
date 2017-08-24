/**
 * 
 */
package first51_75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacobjose123
 *
 */
public class P52_PermutatedMultiples {
	
	private static final int UPPER_LIMIT = 2000000000;
	
	private boolean isHavingSameDigits(int num1,int num2)
	{
		char [] num1Array = Integer.toString(num1).toCharArray();
		char [] num2Array = Integer.toString(num2).toCharArray();
		
		if(num1Array.length != num2Array.length)
			return false;
		else
		{
			List<Integer> num1DigitsList = new ArrayList<Integer>();
			for(int i=0;i<num1Array.length;i++)
				num1DigitsList.add(Character.getNumericValue(num1Array[i]));
			
			for(int i=0;i<num2Array.length;i++)
			{
				int num2Digit = Character.getNumericValue(num2Array[i]);
				if(num1DigitsList.contains(num2Digit))
					num1DigitsList.remove(Integer.getInteger(String.valueOf(num2Digit)));
				else
					return false;
			}
			
			return true;
			
		}

	}

	private boolean isNumberWithPermutatedMultiples(int number,int noOfPermutations)
	{
		
		for(int i=2;i<=noOfPermutations;i++)
		{
			int product =number*i;
			
			if( !(isHavingSameDigits(number, product)) )
				return false;
		}
		
		return true;
	}
	
	private int getNumberWithRequiredNumberOfMultiples(int startNumber,int noOfPermutations)
	{
		for(int number=startNumber;number<=UPPER_LIMIT;number++)
		{
			if(isNumberWithPermutatedMultiples(number, noOfPermutations))
				return number;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		P52_PermutatedMultiples p52_PermutatedMultiples = new P52_PermutatedMultiples();
		
		int noOfPermutationsRequired = 6;
		int startNumber = 10;
		
		System.out.println("Number with "+noOfPermutationsRequired+" permutations is : "+p52_PermutatedMultiples.getNumberWithRequiredNumberOfMultiples(startNumber, noOfPermutationsRequired));

	}

}
