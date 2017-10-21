/**
 * 
 */
package first51_75;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author @jacobjose123
 *
 * 
 */
public class P55_LychrelNumbers {

	public P55_LychrelNumbers() {
		nonLychrelNumberSet = new HashSet<BigInteger> ();
	}

	private static final int ITERATION_LIMIT = 50;
	private static Set<BigInteger> nonLychrelNumberSet;
	
	
	
	/**
	 * @param number - The number to be reversed.
	 * @return - The number reversed and in BigInteger variable.
	 */
	private BigInteger reverseNumber (BigInteger number)
	{
		StringBuffer reversedNumberSB = new StringBuffer("");
		
		char [] digits = number.toString().toCharArray();
		
		for(int i = digits.length-1; i>= 0  ;i-- )
			reversedNumberSB.append(digits[i]);
		
		return new BigInteger ( reversedNumberSB.toString());
	}

	/**
	 * @param number - Checks whether the number is a Palindrom number or not.
	 * @return - Return true if the number is a Palindrom else returns false.
	 */
	private boolean isPalindrome ( BigInteger number )
	{
		char [] digits = number.toString().toCharArray();
		
		
		
		for(int i=0, j =digits.length-1 ; i<j ;i++,j--)
		{
			if( digits[i] != digits[j])
				return false;
		}
		return true;
	}
	
	/**
	 * @param _number - Checks whether number is a Lychrel number or not.
	 * @return Return true if the number is a Lychrel else returns false.
	 */
	private boolean isLychrelNumber ( int _number)
	{
		BigInteger number = new BigInteger( Integer.toString(_number ));
		
		if ( nonLychrelNumberSet.contains(number) )
			return false;
		else
		{
			BigInteger numberReversed = reverseNumber(number);
			
			if (isPalindrome( number.add(numberReversed) ))
			{
				nonLychrelNumberSet.add(number);
				nonLychrelNumberSet.add(numberReversed);
				return false;
			}
			else
			{
//				/*Iteration count is initialized to once since we have reversed once already.*/
				int iterationCount = 1;
				boolean isLychrel = false;
				
				List <BigInteger> numbersTraversedList = new ArrayList<BigInteger> ();
				numbersTraversedList.add(numberReversed);
				
				while (iterationCount < ITERATION_LIMIT)
				{
					isLychrel = true;
					numberReversed = reverseNumber(number);
					numbersTraversedList.add(number);
					number = number.add(numberReversed);
					
					if ( isPalindrome(number))
					{
						isLychrel = false;
						break;
					}
					else
						iterationCount++;
					
				}
				
				if ( !(isLychrel) )
				{
					nonLychrelNumberSet.addAll(numbersTraversedList);
					return false;
				}
				else
					return true;
				
			}
		}
		
	}
	
	/**
	 * @param limit - The Upper Bound, upto which we need to check for Lychrel Numbers.
	 * @return - The count of Lychrel numbers below the limit passed as arguement.
	 */
	public int findNoOfLychrelNumbersBelowLimit ( int limit )
	{
		int count = 0;
		
		for(int i=1; i<limit; i++)
		{
			if(i==349)
				System.out.println("Value of i is "+i);
			
			if ( isLychrelNumber(i) )
				count++;
		}
		
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		P55_LychrelNumbers p55_LychrelNumbers = new P55_LychrelNumbers();
		
//		/*We are giving the limit as ten-thousand as specified in the question.*/
		int limit = 10000;
		
		System.out.println(" Number of Lychrel Numbers below ten-thousand is : "+p55_LychrelNumbers.findNoOfLychrelNumbersBelowLimit(limit));

	}

}
