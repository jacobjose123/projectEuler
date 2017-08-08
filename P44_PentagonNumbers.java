package first26_50;

/**
 * @author jacobjose123
 *
 */
public class P44_PentagonNumbers {
	
//	/*This method will generate a Pentagon number based on the formula.*/
	private int generatePentagonNumber(int index)
	{
		return (index*((3*index)-1))/2;
	}


//	/*The method will return true if the passed number is a pentagon number.*/
	private boolean isPentagonNumber(int number)
	{
//		/*A number is a pentagon number if and only if the result of the following formula is a natural number.*/
		double index = (Math.sqrt((24*number)+1)+1)/6;
		
		
		if(index % 1 == 0)
			return true;
		else
			return false;
		
	}
	
//	/*The following method will find the difference between the 'required pair of pentagonal numbers'.*/ 
	public int findPair()
	{
		for(int i=1;i<10000;i++)
		{
			int pi = generatePentagonNumber(i);
			for(int j=i+1;j<10000;j++)
			{
				int pj = generatePentagonNumber(j);
				if( isPentagonNumber(pi+pj) && isPentagonNumber(pj-pi) )
					return pj-pi;
				
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {

		P44_PentagonNumbers p44_PentagonNumbers = new P44_PentagonNumbers();
		System.out.println("Different of Pentagon Pair : "+p44_PentagonNumbers.findPair());
	}

}
