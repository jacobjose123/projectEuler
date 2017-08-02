package first26_50;

/**
 * @author jacobjose123
 *
 */
public class P27_QuadraticPrimes {

	private static long findProduct()
	{
		long maxCount=0;
		long maxProduct=0;
		
		for(int a=-999;a<=999;a++)
		{
			for(int b=-999;b<=999;b++)
			{
				long count = 0;
				
				while(isPrime(solveEquation(a, b,count)))
				{
					count++;
				}
			
				if(count>maxCount)
				{
					maxCount = count;
					maxProduct = a*b;
				}
			}
		}
		return maxProduct;
	}
	
	private static long solveEquation(int a, int b, long n)
	{
		return n*n+a*n+b;
	}
	
	private static boolean isPrime(long number)
	{
		if(number<=1)
			return false;
		else if(number==2 || number ==3 )
			return true;
		else
		{
			for(int i=2;i<Math.sqrt(number);i++)
			{
				if(number%i==0)
					return false;
			}
			return true;
		}
		
	}
	
	public static void main(String[] args) {

		System.out.println("Max Product : "+findProduct());
	}

}
