package first25;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jacobjose123
 *
 */
public class P23_NonAbundantSum {
	
	private static final int NON_ABUNDANT_NUMBER_UPPER_BOUND = 28123;
	
	private static Set<Integer> abundantNumbersSet;
	private static Set<Integer> abundantNumbersSumSet;
	
	private static int generateSumofNonAbundantNumber()
	{
		int sum=0;
		
		for(int i=1;i<=NON_ABUNDANT_NUMBER_UPPER_BOUND;i++)
		{
			if(abundantNumbersSumSet.contains(i)==false)
				sum+=i;
		}
		return sum;
	}
	
	private static boolean isAbundant(int num)
	{
		int factorSum=0;
		for(int i=1;i<num;i++)
		{
			if(num%i==0)
				factorSum+=i;
		}
		
		return factorSum>num?true:false;
	}
	
	private static void generateAbundantNumbersSet()
	{
		abundantNumbersSet = new TreeSet<Integer>();
		
		for(int i=1;i<=NON_ABUNDANT_NUMBER_UPPER_BOUND;i++)
		{
			if(isAbundant(i))
				abundantNumbersSet.add(i);
		}
		
		
	}
	
	private static void generateAbundantNumbersSumSet()
	{
		abundantNumbersSumSet = new TreeSet<Integer>();
		ArrayList<Integer> abundantNumbersList = new ArrayList<Integer>();
		abundantNumbersList.addAll(abundantNumbersSet);
		for(int i=0;i<abundantNumbersList.size();i++)
		{
			int num1= abundantNumbersList.get(i);
			for(int j=0;j<abundantNumbersList.size();j++)
			{
				int num2 = abundantNumbersList.get(j);
				abundantNumbersSumSet.add(num1+num2);
			}
		}
		
	}

	public static void main(String[] args) {
		
		generateAbundantNumbersSet();
		generateAbundantNumbersSumSet();
		
		System.out.println("Sum of non abundant numbers : "+generateSumofNonAbundantNumber());

	}

}
