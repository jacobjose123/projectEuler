package first26_50;

/**
 * @author jacobjose123
 *
 */
public class P45_TriangularPentagonalAndHexagonal {

//	/*This method will tell us whether the number passed is a Pentagonal Number or not.*/
	private boolean isPentagonal(long number)
	{
		double result = (Math.sqrt((24*number)+1)+1)/6;
		
		if (result % 1 == 0)
			return true;
		else
			return false;
	}
	
//	/*This method will return the next number which is a Triagonal, Pentagonal and Hexagonal.*/
	public long findNextNumber(int currentEqualHexagonalTermIndex)
	{
		for(int i = currentEqualHexagonalTermIndex+1;;i++)
		{
			long hexagonalNumber = i*(2*i-1);
			
//			/*We only have to check whether the number is Pentagonal since all Hexagonal Numbers are triagonal numbers.*/
			if(isPentagonal(hexagonalNumber))
				return hexagonalNumber;
		}
		
	
	}
	
	public static void main(String[] args) {
		
		
		
		P45_TriangularPentagonalAndHexagonal p45_TriangularPentagonalAndHexagonal = new P45_TriangularPentagonalAndHexagonal();
		
//		/*It is specified in question that Hexagonal number with index 143 is triagonal and pentagonal. We have to find the next number.*/
		System.out.println("Next triangular number is : "+p45_TriangularPentagonalAndHexagonal.findNextNumber(143));

	}

}
