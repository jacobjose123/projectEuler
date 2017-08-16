package first51_75;

/**
 * @author jacobjose123
 *
 */
public class P51_PrimeDigitReplacements {
	
//	/*Radix is used to specify the type of the number. i.e Decimal, Binary, etc.*/
	private static final int RADIX = 10;
	
//	/*Upper bound is to specify the maximum number to be checked.*/
	private static final int UPPER_BOUND = 2000000000;

//	/*This method is to check whether the number is prime or not.*/
	private boolean isPrime(int number)
	{
		if(number%2==0)
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

//	/*This method when given the values of i,j and k will return the least prime number of that family of Primes.*/
	private int getLeastPrimeNumberOfFamily(int i, int j,int l, int number)
	{
		StringBuilder numberSB = new StringBuilder(Integer.toString(number));
		
		for(int k=0;k<=9;k+=1)
		{
			
			numberSB = new StringBuilder(Integer.toString(number));
			numberSB.setCharAt(i, Character.forDigit(k, RADIX));
			numberSB.setCharAt(j, Character.forDigit(k, RADIX));
			numberSB.setCharAt(l, Character.forDigit(k, RADIX));

			
			int swappedNumber = Integer.valueOf(numberSB.toString());
			
			
			if(isPrime(swappedNumber))
			{
				return swappedNumber;
			}
			

		}
		return number;
		
		
	}
	
//	/*This method will return the number of primes when replacing the digits at position i,j and k of the number.*/
	private int getNumberOfPrimes(int i, int j,int l, int number)
	{
		StringBuilder numberSB = new StringBuilder(Integer.toString(number));
		int primeCount = 0, startNumber=0, incrementValue=1;
		
		if(i==0)
		{
			incrementValue=1;
			startNumber=1;
		}
		else if(j==numberSB.length()-1)
		{
			incrementValue=2;
			startNumber=1;
		}
		else
		{
			incrementValue=1;
			startNumber=0;
		}
		
		int leastPrimeNumber =0;
		
		for(int k=startNumber;k<=9;k+=incrementValue)
		{
			
			numberSB = new StringBuilder(Integer.toString(number));
			numberSB.setCharAt(i, Character.forDigit(k, RADIX));
			numberSB.setCharAt(j, Character.forDigit(k, RADIX));
			numberSB.setCharAt(l, Character.forDigit(k, RADIX));

			
			int swappedNumber = Integer.valueOf(numberSB.toString());
			
			
			if(isPrime(swappedNumber))
			{
				primeCount++;
				
//				System.out.println("i :"+i+"\t"+" j :"+j+"\t"+" l : "+l+"\t"+"Swapped Number : "+swappedNumber+"\t"+"Prime Number");
				
				if(leastPrimeNumber<swappedNumber)
					leastPrimeNumber=swappedNumber;
			}
//			else
//				System.out.println("i :"+i+"\t"+" j :"+j+"\t"+" l : "+l+"\t"+"Swapped Number : "+swappedNumber);


		}
		
		return primeCount;
		
	}

//	/*This method will return a the least prime number having the specified number of primes in it's prime family.*/	
	private int getPrimeNoWithNPrimes(int startNumber,int noOfPrimesRequired)
	{
		StringBuilder numberSB = new StringBuilder(Integer.toString(startNumber));
		for(int number=startNumber;number<=UPPER_BOUND;number++)
		{
			for(int i=0;i<numberSB.length();i++)
			{
				for(int j=i;j<numberSB.length();j++)
				{
					
					for(int l=j;l<numberSB.length();l++){
						int noOfPrimes = getNumberOfPrimes(i, j,l, number);
						
						System.out.println(number+"\t\t"+"Number of Primes : "+noOfPrimes);

						if(noOfPrimes>=noOfPrimesRequired && isPrime(number))
						{
							
							return getLeastPrimeNumberOfFamily(i, j, l, number);
						}
					}
					
				}
			}
		}
		return 0;
	}

	public static void main (String [] args)
	{
		P51_PrimeDigitReplacements p51_PrimeDigitReplacements = new P51_PrimeDigitReplacements();
		
//		/*We start searching from 56003 since it has been specified in question 56003 is the least number having 7 prime family.*/
		int startNumber =56002;
		int noOfPrimesRequired =8;
		try
		{
			System.out.println("Number having "+noOfPrimesRequired+" prime value family is  : "+p51_PrimeDigitReplacements.getPrimeNoWithNPrimes(startNumber, noOfPrimesRequired));

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
