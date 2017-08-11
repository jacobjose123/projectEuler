package first26_50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacobjose123
 *
 */
public class P50_ConsecutivePrimeSum {
	

//	/*This method is used to check whether a number is a prime number or not.*/
	private boolean isPrime(int number)
	{
		if(number%2==0 )
			return false;
		else
		{
			for(int i=3;i<=Math.sqrt(number);i++)
			{
				if(number % i ==0 )
					return false;
			}
			
			return true;
					
		}
	}
	
//	/*This method will return the biggest prime number that is the sum of consecutive prime numbers below the limit specified.*/
	private int getMaxPrimeNumber(int limit)
	{
		if(limit<2)
			return 1;
		else
		{
			int sum=2;
			List<Integer> primeNumbersUsed = new ArrayList<Integer>();
			primeNumbersUsed.add(2);
			
//			/*Here we are adding all the primes numbers until the sum is greater than or equal to the limit.*/
			for(int i=3; i<=limit  && sum<limit ;i+=2)
			{
				if( isPrime(i))
				{
					if(sum+i<=limit)
					{
						sum+=i;
						primeNumbersUsed.add(i);
					}
				}
			}
			
			
			int i = 0;
			
//			/*Since we want to find largest consecutive prime numbers sum, we can check whether the sum is prime 
//			else we can reduce the sum starting from the smaller prime numbers.*/
			while( !(isPrime(sum)))
			{
				sum-=primeNumbersUsed.get(i);
				i++;
			}
			
			
			return sum;
		}
	}

	

	
	public static void main(String[] args) {
		
		P50_ConsecutivePrimeSum p50_ConsecutivePrimeSum = new P50_ConsecutivePrimeSum();
	
		int limit =1000000;
		
	
		int sumUptoN = p50_ConsecutivePrimeSum.getMaxPrimeNumber(limit);
		System.out.println("Sum of first "+limit+" prime number is : "+sumUptoN);
		
		
		
		
		
	}

}
