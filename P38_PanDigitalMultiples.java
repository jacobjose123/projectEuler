package first26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacobjose123
 *
 */

/*
 * In the program I am using a brute force method to solve the problem.
 */
public class P38_PanDigitalMultiples {
	
	private static final int UPPER_PAN_NUMBER_LIMIT = 987654321;
	
	private List<Character> digits0to9List;
	
	private boolean removeFromPanDigitsList(int number)
	{
		if(digits0to9List.size()<=0)
			return false;
		else
		{
			char [] digitsArray = String.valueOf(number).toCharArray();
			for(int i=0;i<digitsArray.length;i++)
			{
				int index= digits0to9List.indexOf(digitsArray[i]);
				if(index>=0)
					digits0to9List.remove(index);
				else
					return false;
			}
			return true;
		}
	}

	private int getPanDigitProduct(int number)
	{
		digits0to9List = new ArrayList<Character>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
		StringBuffer productDigitsSB = new StringBuffer("0");
		
		
		for(int i=1;i<=9;i++)
		{
			int product = number*i;
			if(removeFromPanDigitsList(product))
				productDigitsSB.append(product);
			else
				break;
		}
		return Integer.valueOf(productDigitsSB.toString());
		
	}

	private int getLargestPanMultiple()
	{
		int largestMultiple = 1;
		
		
		for(int i=1;i<=10000/*UPPER_PAN_NUMBER_LIMIT*/ ;i++)
		{
			int panDigitalProduct = getPanDigitProduct(i);
			
//			/*Checking if the product obtained is greater than the existing product, if greater then updating the value of largest number*/ 
			largestMultiple = largestMultiple<panDigitalProduct?panDigitalProduct:largestMultiple;
			
			System.out.println("i : "+i+"\t\t"+"Largest : "+largestMultiple);
			
			
		}
		return largestMultiple;
	}
	
	public static void main(String[] args) {
		
		P38_PanDigitalMultiples p38_PanDigitalMultiples = new P38_PanDigitalMultiples();
		int largestPanDigitMultple = p38_PanDigitalMultiples.getLargestPanMultiple();
		
		System.out.println("Largest PanDigit Multiple is : "+largestPanDigitMultple);

	}

}
