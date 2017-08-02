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
public class P12_HighlyDivisibleTriangularNumbers {
	
	private static final int MAX_FACTORS = 500;

	public static void main(String[] args) {
		
		int factorCount =0;
		long naturalNumber =0;
		long triangularNumber = 0;
		
		while(factorCount<MAX_FACTORS)
		{
			naturalNumber++;
			triangularNumber = triangularNumber+naturalNumber;
			factorCount = calculateFactorCount(triangularNumber);
			
			System.out.print(triangularNumber+" : "+factorCount);

			
			System.out.println("");
		}
		
		
		
		System.out.println("Required Triangular Number : "+triangularNumber);

	}
	
	private static int calculateFactorCount(long num)
	{
		int count=0;
		for(long i=1;i<=num;i++)
		{
			if(num%i==0)
			{
//				System.out.print(i+" ");
				count++;
			}
		}
		
		return count;
	}

}
