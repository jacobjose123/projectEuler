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
public class P3_PrimeFactors {

	/**
	 * @param args
	 */
	
	private static boolean isPrime(long num)
	{
		if(num==1 || num==2)
			return true;
		
		for(int i=2;i<Math.sqrt(num);i++)
		{
			if(num%i==0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		BigInteger largestFactor= new BigInteger("2");
		
//		long n= 600851475143;
		BigInteger bn = new BigInteger("600851475143");
		BigInteger i= new BigInteger("1");
		
		while(bn.longValue()>1)
		{
//			System.out.println(bn.longValue());
			if(isPrime(i.longValue()))
			{
//				System.out.println("bn.mod(i)) "+bn.mod(i));
				if(bn.mod(i).equals(new BigInteger("0")))
				{
//					largestFactor=i;
//					n/=i;
//					i=1;
					
					largestFactor = i;
					bn = bn.divide(i);
					i = new BigInteger("1");
					System.out.println(largestFactor);
				}
			}
			i= i.add(new BigInteger("1"));
		}
		System.out.println(largestFactor);
	}

}
