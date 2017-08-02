package first26_50;

/**
 * @author jacobjose123
 *
 */

///*A Non trivial fraction is fraction whose value(when divided) will remain same, even after the common digits in both the numbers are removed.*/

public class P33_DigitCancellingFractions {
	
//	/*This function will simplify the numerator and denominator and returns the simplified numberator*/
	private static int factorizeAndGetDenominator(int numerator, int denominator)
	{
		int i=2;
		while(i<=numerator)
		{
			if(numerator%i==0 && denominator%i==0)
			{
				numerator/=i;
				denominator/=i;
			}
			else
				i++;
		}
		
		return denominator;
	}
	
//	/*This function returns true if a fraction is non-trivial fraction*/ 
	private static boolean isNonTrivial(int i,int j)
	{
		
//		/*Checking if the numbers i & j can we divided by 10 also*/
		int iOnes = i%10;
		int jOnes = j%10;
		
		if(iOnes==0 || jOnes==0)
			return false;
		else 
		{
			int iTens = i/10;
			int jTens = j/10;
			
			float expectedResult = (float)i/j;
			float result=1;
			
//			/*Dividing the non-common Digits*/
			if(iOnes== jTens)
				result=(float)iTens/jOnes;
			else if(iOnes == jOnes)
				result=(float)iTens/jTens;
		 
			if(expectedResult== result )
				return true;
			else
				return false;
		}
	}
	
	private static int computeNonTrivialFractions()
	{
		int numerator =1;
		int denominator = 1;
		for(int i=10;i<100;i++)
		{
			for(int j=i+1;j<100;j++)
			{
//				/*Checking int range for i=10-99 and j=10-99*/
				if(isNonTrivial(i, j))
				{
					System.out.print("Non Trivial Solutions i:"+i+"\t\t"+"j:"+j);
					System.out.print("\t\t"+numerator+"/"+denominator);
					System.out.println("");
					
					numerator*=i;
					denominator*=j;
				}
			}
		}
		
		
		return factorizeAndGetDenominator(numerator, denominator);
	}

	public static void main(String[] args) {
		
		System.out.println("Product of Denominator : "+computeNonTrivialFractions());
		
		System.out.println("factorizeAndGetDenominator(49, 98) : "+factorizeAndGetDenominator(49, 98));

	}

}
