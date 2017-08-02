/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

import java.math.BigInteger;

/**
 * @author a-7383
 *
 */
public class P10_SummationOfPrimeNumbers {

	private static int LIMIT = 2000000;
	private static boolean isPrime(int num)
	{
		if(num==1 || num == 2|| num == 3)
			return true;
		else
		{
			for(int i=2;i<=Math.sqrt(num);i++)
			{
				if(num%i==0)
					return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		BigInteger sum = new BigInteger("0");
		
		for(int i=2;i<LIMIT;i++)
		{
			
			if(isPrime(i))
			{
				System.out.println("Prime Number: "+i);
				sum=sum.add(new BigInteger(String.valueOf(i)));
			}
			else
				System.out.println(i);
		}
		
		System.out.println("Sum : "+sum);

	}

}
