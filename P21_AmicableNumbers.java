package first25;

import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

/**
 * @author jacobjose123
 *
 */
public class P21_AmicableNumbers {

	private static Set<Integer> amicableNumbers;
	
	private static int amicableSum()
	{
		int sum=0;
		for(int amicableNumber:amicableNumbers)
			sum+=amicableNumber;
		
		return sum;
	}
	
	private static void generateAmicableNumbers(int limit)
	{
		amicableNumbers = new HashSet<Integer>(); 
		for(int a=1;a<limit;a++)
		{
			int b = factorsSum(a);
			
			if(a!=b && a==factorsSum(b))
			{
				amicableNumbers.add(a);
				amicableNumbers.add(b);
				System.out.println(a+" & "+b+" is an amicable pair.");
			}
				
		}
			
	}
	
	private static int factorsSum(int num)
	{
		int sum=0;
		for(int i=1;i<num;i++)
		{
			if(num%i==0)
				sum+=i;
		}
		return sum;
	}
	

	
	public static void main(String[] args) {

		int lowerLimit = 1;
		int upperLimit =10000;
		
		
		generateAmicableNumbers(upperLimit);
		
		System.out.println("Amicable Digits sum : "+amicableSum());
		
//		System.out.println("Sum of Amicable numbers : "+findTotalSum(lowerLimit, upperLimit));
	}
	
	private static int findTotalSum(int lowerLimit, int upperLimit)
	{
		int sum=0;
		for(int i=lowerLimit;i<=upperLimit;i++)
			sum+=factorsSum(i);
		
		return sum;
	}
	
	private static int findTotalSum( int upperLimit)
	{
		int sum=0;
		for(int i=1;i<=upperLimit;i++)
			sum+=factorsSum(i);
		
		return sum;
	}

}
