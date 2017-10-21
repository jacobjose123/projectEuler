/**
 * 
 */
package first51_75;

import java.math.BigInteger;

/**
 * author @jacobjose123
 *
 * 
 */
public class P58_SpiralPrimes {
	
	private static final int TWO = 2;
	
	
	/**
	 * @param requiredMinimumRatioPercentage - The minimum percentage that we want.
	 * @return This method will return side length of the square spiral where the ratio of prime/total numbers is 
	 * 					less than or equal of the required number input
	 */
	public int findRowSize(float requiredMinimumRatioPercentage)
	{
		/*The totalCount is initialized as one since we need to consider the number 1 in the square center.*/
		int primeCount =0, totalCount =1;
		/*Row size is initialized as 1 since we are starting from the middle element 1.*/
		int currentRowSize = 1;
		
		double currentRatio ;
		

		do
		{
			/*Increating the row size by 2 since for each spiral the rows gets incremented by 2/*/
			currentRowSize+=2;
			
			
			BigInteger currentNumber = new BigInteger(String.valueOf(currentRowSize));
			BigInteger cornerElementDifference = new BigInteger (String.valueOf(currentRowSize-1));
			
			currentNumber = new BigInteger(String.valueOf(currentRowSize));
			currentNumber = currentNumber.pow(TWO);
			
			int i=0;
			
//			System.out.println("Current Diagonal Elements : ");
			while(i++<4)
			{
				System.out.print(currentNumber+" ");
				
				if( currentNumber.isProbablePrime(Integer.MAX_VALUE) )
					primeCount++;
				
				currentNumber = currentNumber.subtract(cornerElementDifference);
			}
			
			
			/*Incrementing the total count by 4 since 4 new numbers are added/*/ 
			totalCount+=4;
			
			/*We are calculating the new ratio after adding a new spiral row.*/
			currentRatio = ((double)primeCount/totalCount) *100 ;
			System.out.println(", "+currentRatio);

			
		}while(currentRatio>=requiredMinimumRatioPercentage );
		
		return currentRowSize;
		
		
	}

	
	public static void main (String [] args )
	{
		float requiredMinimumRatio = 10;
		
		P58_SpiralPrimes p58_SpiralPrimes = new P58_SpiralPrimes();
		System.out.println("Row Size where ratio falls below "+ requiredMinimumRatio+"  : "+p58_SpiralPrimes.findRowSize(requiredMinimumRatio));
		
	}
}













