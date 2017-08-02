/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

/**
 * @author a-7383
 *
 */
public class P6_SumSquareDifference {

	
	private static final int upperLimit = 100;
	private static long naturalNumberSum =0;
	private static long sumOfNatualNumberSquares =0;
	
	public static void main(String[] args) {

		for(int i=1;i<=upperLimit;i++)
		{
			naturalNumberSum = naturalNumberSum+i;
			sumOfNatualNumberSquares = sumOfNatualNumberSquares + i*i;
		}
		
		System.out.println("Sum of Natural Numbers :"+naturalNumberSum);
		naturalNumberSum*=naturalNumberSum;
		System.out.println("Square of the Sum :"+naturalNumberSum);
		System.out.println("Sum of Squares of Natural Numbers :"+sumOfNatualNumberSquares);
		
		System.out.println("-----------------------------------------------");
		
		System.out.println(naturalNumberSum-sumOfNatualNumberSquares);
		
	}
	
	

}
