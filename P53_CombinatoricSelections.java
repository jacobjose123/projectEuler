/**
 * 
 */
package first51_75;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * author @jacobjose123
 *
 * 
 */
public class P53_CombinatoricSelections {
	
	private static Map<BigInteger,BigInteger> factorialMap ;
	
	private static final BigInteger ONE = new BigInteger ("1");
	
	/**
	 * @param _n - n value of nCr
	 * @param _r - r value of nCr.
	 * @return Return the value of nCr.
	 */
	private BigInteger getnCr (int _n, int _r)
	{
		BigInteger nCr = new BigInteger("0");
		
		BigInteger r = new BigInteger(Integer.toString(_r));
		BigInteger n = new BigInteger(Integer.toString(_n));
		
		nCr = factorial(r);
		nCr = nCr.multiply( factorial (n.subtract(r)) );
		nCr = factorial(n).divide(nCr);
		
		return nCr;

	}

	/**
	 * @param nLowerBound - Specified the Lower Bound value of n from which we should start computing nCr
	 * @param nUpperBound - Specfied the Upper Bound Value of n,
	 * @param limitSpecified - The Limit or the minimum value of nCr we are expecting, in this context limit is one-million
	 * @return Returns the number of nCr Terms greater than the limit specified and within the n bound of n
	 */
	public int findnCrValuesGreaterThanLimit (int nLowerBound, int nUpperBound, int limitSpecified )
	{
		BigInteger limit = new BigInteger(Integer.toString(limitSpecified));
		
		int nCrOverLimitCount = 0;
		
		
		
		for(int n= nLowerBound ; n<= nUpperBound ; n++)
		{
			for(int r =1 ; r<n ; r++ )
			{
				BigInteger nCr = getnCr(n, r);
				if( nCr.compareTo(limit) == 1 )
					nCrOverLimitCount++;
			}
		}
		
		return nCrOverLimitCount;
		
	}
	
	/**
	 * @param number - The number who factorial is to be found out.
	 * @return The factorial of the number in BigInteger Data format
	 */
	private BigInteger factorial (BigInteger number)
	{
		if( factorialMap.containsKey(number) )
			return factorialMap.get(number);
		else
		{
			if( number.compareTo(ONE) == 1)
			{
				BigInteger factorialTerm = number.multiply( factorial( number.subtract(ONE)) );
				factorialMap.put(number,factorialTerm);
				return factorialTerm;
			}
			else
				return ONE;
		}
	}
	
	/**
	 * In the constructor we are initializing the HashMap for the factorial terms. 
	 */
	public P53_CombinatoricSelections ()
	{
		this.factorialMap = new HashMap<BigInteger,BigInteger>();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		P53_CombinatoricSelections p53_CombinatoricSelections = new P53_CombinatoricSelections();
		
		int limitSpecified = 1000000;
		int nLowerBound = 23;
		int nUpperBound = 100;
		
		
		int noOfnCrS = p53_CombinatoricSelections.findnCrValuesGreaterThanLimit(nLowerBound, nUpperBound, limitSpecified);
		
		System.out.println(" No of nCr-s greater than one-million is "+noOfnCrS);

	}

}
