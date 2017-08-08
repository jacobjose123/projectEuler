package first26_50;

/**
 * @author jacobjose123
 *
 */
public class P46_GoldbachsOtherConjecture {
	
//	/*This Method is to check whether the number input is a prime number or a composite number.*/
	private boolean isPrime(int number)
	{
		if(number%2==0)
			return false;
		else
		{
			for(int i=3;i<=Math.sqrt(number);i++)
			{
				if(number % i ==0 )
					return false;
			}
			
			return true;
					
		}
	}
	
//	/*This method will tell us whether the number we have passed is a perfect square or not.*/
	private boolean isPerfectSquare(int number)
	{
		double root = Math.sqrt(number);
		
		if(root % 1 ==0 )
			return true;
		else
			return false;
	}

//	/*This method will return the closest lower prime for the the number input.*/ 
	private int getClosestSmallerPrimeNumber(int number)
	{
		int i=number-2;
		
		for(;!isPrime(i) && i>0; i--);
		
		return i;
	}
	
//	/*This method will check whether a number satisfies the Goldbach's theorm.*/	
	private boolean isGoldbachsNumber(int number)
	{
		int primeNumber = getClosestSmallerPrimeNumber(number);
		
		int square = (number-primeNumber)/2;
		int squareRoot = (int)Math.sqrt(square);
		
		while(primeNumber>0)
		{
//			/*Here we are checking whether the Goldbach's conditions is satisfied.*/			
			if( (isPerfectSquare(square)) && ((primeNumber+2*squareRoot*squareRoot)== number) )
				return true;
//			/*If the square root is not a perfect square we increase it.*/
			else if( !isPerfectSquare(square) || ((primeNumber+2*squareRoot*squareRoot)<number) ) 
			{
				squareRoot++;
				square= squareRoot*squareRoot;
			}
//			/*If the Prime number is too large then we use the next lowest prime number.*/
			else if((primeNumber+2*squareRoot*squareRoot)> number)
				primeNumber = getClosestSmallerPrimeNumber(primeNumber);
		}
		
		return false;
		
	}
	
	
	
//	/*This is the public method that will return the lowest-odd composite number not Satisfying Goldbach's theorm. */	
	public int findSmallestOddComposite()
	{
		int i=3;
		
		for(;;i+=2)
		{
			System.out.println(i);
			
			
			if(!isPrime(i)  &&  !(isGoldbachsNumber(i)) )
				return i;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		P46_GoldbachsOtherConjecture p46_GoldbachsOtherConjecture = new P46_GoldbachsOtherConjecture();
		
//		System.out.println("Closest Prime number to 5777 is "+p46_GoldbachsOtherConjecture.getClosestSmallerPrimeNumber(5777));
//		System.out.println(p46_GoldbachsOtherConjecture.isGoldbachsNumber(5777));
		
		System.out.println("Smallest Number not Satisfying the condition is : "+p46_GoldbachsOtherConjecture.findSmallestOddComposite());

	}

}
