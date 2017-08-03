package first26_50;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jacobjose123
 *
 */
public class P35_CircularPrimes {

	private  void displaySet(Set<Integer> setTobeDisplayed)
	{
		System.out.println("Set Elements are : ");
		int counter =1;
		for(int setElement: setTobeDisplayed)
			System.out.println((counter++)+"."+setElement);
	}
	
	public  int findCircularPrimes(int limit)
	{
		Set<Integer> primaryNumberSet = new TreeSet<Integer>();
		
		for(int i=2;i<limit;i++)
		{
			if(i==103)
				System.out.println("i is 103");
			
			System.out.println(i);
			if( !primaryNumberSet.contains(i) )
			{
				if( (isPrime(i)) && (isCircular(i)) )
				{
					int possibleRotations = String.valueOf(i).length();
					int currentRotation =1;
					int rotatedNumber = i;
					
					while(currentRotation<=possibleRotations)
					{
						rotatedNumber = rightRotate(i,currentRotation);
						
						currentRotation++;
						primaryNumberSet.add(rotatedNumber);
					}
					primaryNumberSet.add(i);
					
				}
			}
		}
		
		displaySet(primaryNumberSet);
		
		return primaryNumberSet.size();
	}
	
	private  boolean isCircular(int number)
	{
		int possibleRotations = String.valueOf(number).length();
		int currentRotation =1;
		int rotatedNumber = number;
		
		while(currentRotation<=possibleRotations)
		{
			rotatedNumber = rightRotate(number,currentRotation);
			
			currentRotation++;
//			/*Here we are checking whether the number we obtain after rotation is prime or not. If not prime method return false*/
			if( !isPrime(rotatedNumber))
				return false;
		}
		
		/*If all the circular rotations are prime then the method will return true*/
		return true;
	}
	
	private  boolean isPrime(long num)
	{
		if(num==1 || num==2)
			return true;
		
		for(int i=2;i<=Math.sqrt(num);i++)
		{
			if(num%i==0)
				return false;
		}
		return true;
	}
	
	private  int rightRotate(int number,int times)
	{
		String numberRightRotated = String.valueOf(number);
		
		while(times-->0)
			numberRightRotated = numberRightRotated.substring(1, numberRightRotated.length())+numberRightRotated.charAt(0);
		
		return Integer.valueOf(numberRightRotated);
	}

	public static void main(String[] args) {
		int limit = 1000000;
		P35_CircularPrimes p35_CircularPrimes = new P35_CircularPrimes();
		
		System.out.println("Number of Circular Primes below "+limit+" is : "+p35_CircularPrimes.findCircularPrimes(limit));
	}

}
