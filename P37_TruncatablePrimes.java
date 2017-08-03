package first26_50;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jacobjose123
 *
 */
public class P37_TruncatablePrimes {
	
	private  boolean isPrime(int num)
	{
		
		
//		/*In this context the number '1' is not considered as a prime number.*/
		
		if(num==0 || num ==1)
			return false;
		
		else if ( num==2)
			return true;
		
		for(int i=2;i<=Math.sqrt(num);i++)
		{
			if(num%i==0)
				return false;
		}
		return true;
	}

	private boolean isTruncatablePrime(int number)
	{
		
		int possibleNumberOfTruncations = String.valueOf(number).length();
		
		int divisor = 10;
//		/*Here we are truncating the elements from the right side towards left side*/
		while(--possibleNumberOfTruncations>0 )
		{
			if( !isPrime(number%divisor) )
				return false;
			divisor*=10;
		}
		
		possibleNumberOfTruncations = String.valueOf(number).length();
		divisor = 10;
//		/*Here we are truncating the elements from the left side towards right side*/
		while(--possibleNumberOfTruncations>0 )
		{
			if( !isPrime(number/divisor) )
				return false;
			divisor*=10;
		}
		
		
		return true;
		
	}
	
	private  void displaySet(Set<Integer> setTobeDisplayed)
	{
		System.out.println("Set Elements are : ");
		int counter =1;
		for(int setElement: setTobeDisplayed)
			System.out.println((counter++)+"."+setElement);
	}
	
	private long findTruncatablePrimeNumbersSum(int countLimit)
	{
		int count=0;
		Set<Integer> truncatablePrimeSet = new TreeSet<Integer>();
		
//		/*We check the numbers for truncatable prime from 11 since 1,2,3,5 & 7 are not considered as truncatable primes.*/
		for(int i=11;count<countLimit;i++)
		{
			if(i==3797)
				System.out.println("i is 3797");
			
			System.out.println(i+"\t\t"+"Count : "+count);
			if( isPrime(i) && isTruncatablePrime(i) )
			{
				
				truncatablePrimeSet.add(i);
				count++;
				System.out.println(i+"\t\t"+"Count : "+count+"\t\t"+" Truncatable Prime");
			}
		}
		
		long sum=0;
		for( int truncatablePrime : truncatablePrimeSet)
			sum+=truncatablePrime;
		
		displaySet(truncatablePrimeSet);
		return sum;
	}
	
	public static void main(String[] args) {
		int countLimit = 11;
		
		P37_TruncatablePrimes p37_TruncatablePrimes = new P37_TruncatablePrimes();
		long sum = p37_TruncatablePrimes.findTruncatablePrimeNumbersSum(countLimit);
		
		System.out.println("Sum of Truncatable Prime Number is : "+sum);

	}

}
