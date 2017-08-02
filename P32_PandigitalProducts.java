package first26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacobjose123
 *
 */
public class P32_PandigitalProducts {
	
	private static Set<Integer> pandigitalSet = new HashSet<Integer>();
	private static final int UPPER_LIMIT = 987654321;
	
	
	private static void checkRange(int _a,int _b)
	{
		int aLowerLimit = (int)Math.pow(10, _a-1);
		int aUpperLimit = (int)Math.pow(10, _a);
		
		int bLowerLimit = (int)Math.pow(10, _b-1);
		int bUpperLimit = (int)Math.pow(10, _b);
		
		for(int i=aLowerLimit;i<aUpperLimit;i++)
		{
			for(int j=bLowerLimit;j<bUpperLimit;j++)
			{
				StringBuffer a = new StringBuffer(String.valueOf(i));
				StringBuffer b = new StringBuffer(String.valueOf(j));
				
				System.out.print(a+" * "+b+" = "+i*j);
				
				System.out.print("\ta.substring(0,1) :"+a.substring(0,1));
				
				System.out.println("");
				
				if( b.indexOf(a.toString())==-1 )
					if(isPanDigital(i, j))
					{
						pandigitalSet.add(i*j);
					}
			}
		}
	}
	
	
	private static void findPandigitNumbersSum()
	{
		long sum=0;
		
		int i=0;
		for(int panDigit: pandigitalSet)
		{
			sum+=panDigit;
			System.out.println((++i)+"."+panDigit+"\t\t\t"+" Sum : "+sum);
		}
		System.out.println("Sum of PanDigit Numbers is : "+sum);
	}
	
	private static boolean isPanDigital(int multiplicant,int multiplier)
	{
		String a = multiplicant+"";
		
		
		String b = multiplier+"";
		String c = (multiplicant*multiplier)+"";
		char [] digitsArray = (String.valueOf(multiplicant)+String.valueOf(multiplier)+String.valueOf(multiplier*multiplier)).toCharArray();
		
		digitsArray = (String.valueOf(multiplicant)+String.valueOf(multiplier)+String.valueOf(multiplier*multiplier)).toCharArray();
		
		char [] abc = (a+b+c).toCharArray();
		
		digitsArray = abc;
		
		if(digitsArray.length!=9)
			return false;
		else
		{
			List<Character> digitsList = new ArrayList<Character>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
			for(int i=0;i<digitsArray.length;i++)
			{
				System.out.println("digitsArray.length ="+digitsArray.length+"    i = "+i);
				if( digitsList.contains(digitsArray[i]))
				{
					digitsList.remove(Character.valueOf(digitsArray[i]));
				}
				else
					return false;
			}
			if(digitsList.size()==0)
				return true;
			else
				return false;
		}
		
	}
	
	

	public static void main(String[] args) {

//		findPandigitNumbers();
//		System.out.println("1");
//		findPandigitNumbersSum();
		
//		findPandigits();
		checkRange(1, 4);
		checkRange(1, 3);
		checkRange(2, 3);
		checkRange(2, 2);
		checkRange(3, 3);
		findPandigitNumbersSum();

		
	}

}

/*

//Unwanted Methods

private static void findPandigitNumbers()
{
	pandigitalSet = new HashSet<Integer>();
	for(int i=1;i<UPPER_LIMIT;i++)
	{
		for(int j=1;j<UPPER_LIMIT;j++)
		{
			if(isPanDigital(i, j))
			{
				System.out.println(i+" * "+j+" = "+i*j+" PanDigit Number");
				pandigitalSet.add(i*j);
			}
			else
				System.out.println(i+" * "+j+" = "+i*j);
		}
	}
}



*/