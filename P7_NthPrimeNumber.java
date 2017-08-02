/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

import java.math.BigInteger;


public class P7_NthPrimeNumber {
	
	private static final int UPPER_LIMIT = 10001;
	
	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger ONE = new BigInteger("1");
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger THREE= new BigInteger("3");
	private static final BigInteger FIVE = new BigInteger("5");
	private static final BigInteger SEVEN = new BigInteger("7");

	
	private static boolean isPrimeNumber(BigInteger num)
	{
		if(num.equals(TWO) || num.equals(THREE) || num.equals(FIVE) || num.equals(SEVEN))
			return true;
//		else if(num.mod(TWO).equals(ZERO) ||num.mod(THREE).equals(ZERO) || num.mod(FIVE).equals(ZERO) || num.mod(SEVEN).equals(ZERO))
//			return false;
		else 
		{
			BigInteger half = num.divide(TWO);
			for(BigInteger i = new BigInteger("2"); (i.compareTo(half)==-1 || i.compareTo(half)==0) ;i=i.add(ONE))
			{
				if(num.mod(i).equals(ZERO))
					return false;
				
			}
		}
		return true;
	}
	
	private static boolean isPrime(long num)
	{
		if(num ==2 || num == 3 || num == 5 || num == 7)
			return true;
		else if(num%2==0 || num%3==0 || num%5==0 || num%7==0)
			return false;
		else
			return true;
	}
	
	public static void main(String [] args)
	{
		BigInteger i= new BigInteger("1");
		int count = 1;
//		long primeNumber  =0;
		
		while(count<=UPPER_LIMIT)
		{
			i = i.add(new BigInteger("1"));
//			if(i.isProbablePrime(1))
			if(isPrimeNumber(i))
			{
				System.out.println(count+"."+i);
				count++;
//				primeNumber = i;
				
			}
			
			
		}
		
		System.out.println("----------------------------------");
		System.out.println(+UPPER_LIMIT+"th Prime Number is  :"+i);
	}

}
