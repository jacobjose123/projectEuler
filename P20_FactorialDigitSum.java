/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

import java.math.BigInteger;


/**
 * @author jacobjose123
 *
 */
public class P20_FactorialDigitSum {
	
	private static final BigInteger ONE = new BigInteger("1");

	private static BigInteger factorial(BigInteger num)
	{
		if(num.equals(ONE))
			return ONE;
		else
		{
			num = num.multiply(factorial(num.subtract(ONE)));
			return num;
		}
	}
	
	private static int digitSum(BigInteger num)
	{
		
		char [] digits =  String.valueOf(num).toCharArray();
		
		int sum=0;
		for(int i=0;i<digits.length;i++)
			sum+=Character.getNumericValue(digits[i]);
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		BigInteger term = new BigInteger("100");
		
		System.out.println(term+"! : "+factorial(term));
		System.out.println("Digits Sum : "+digitSum(factorial(term)));

	}

}
