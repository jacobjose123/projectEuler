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


public class P57_SquareRootConvergents {
	
	private static final BigInteger TWO = new BigInteger("2");
	
	/**
	 * This class is used to represent each term as an object
	 * num - Numerator
	 * denom  - Denominator
	 * 
	 */
	class Term {
		public BigInteger num;
		public BigInteger denom;
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return num + "/" + denom;
		}
		
		
	}
	
	private static BigInteger tempNum ;
	
	/**
	 * @param currentTerm
	 * @return This will return the next num and denom after calculating (2+1/(num/denom) )
	 */
	private Term getNextSubTerm( Term currentTerm )
	{
		tempNum = currentTerm.num;
		currentTerm.num = tempNum.multiply(TWO);
		currentTerm.num = currentTerm.num.add(currentTerm.denom) ;
		currentTerm.denom = tempNum;
		
		return currentTerm;
	}
	
	/**
	 * @param currentTerm
	 * @return This method will check if the number of digits in numerator is greater than that of denominator
	 * 					after the calculation (1 + 1/(num/denom) )  
	 */
	private boolean checkIfNumExceedsDenom (Term currentTerm)
	{
		

		
		if( String.valueOf(currentTerm.num.add(currentTerm.denom)).length() > String.valueOf(currentTerm.num).length() ) 
			return true;
		else
			return false;
	}

	/**
	 * @param noOfTerms
	 * @return This method will return the total number of terms where the number of digits in numerator 
	 * 					is greater than the number of digits in the denominator, up to the specified  number of terms.  
	 */
	public int findNumberOfTerms (int noOfTerms)
	{
		Term currentTerm = new Term();
		currentTerm.num = new BigInteger("2");
		currentTerm.denom = new BigInteger("1");
		int count =0;
		for(int i=0;i<noOfTerms;i++)
		{
			System.out.println((i+1)+" " +currentTerm); 
			if( checkIfNumExceedsDenom(currentTerm) )
				count++;
			
			currentTerm = getNextSubTerm(currentTerm);
		}
		return count;
	}

	public static void main (String [] args )
	{
		P57_SquareRootConvergents p57_SquareRootConvergents = new P57_SquareRootConvergents();
		
		int noOfTermsLimit = 1000;
		
		int noOfFractions = p57_SquareRootConvergents.findNumberOfTerms(noOfTermsLimit);
		
		System.out.println("Number of Fractions with the digits in numerator greater than that of denominator is : "+noOfFractions);
		
		
		
		
		
		
		
		
		
	}
}
