package first26_50;

/**
 * @author jacobjose123
 *
 */
public class P36_DoubleBasePalindromes {

	
	private  boolean isPalindrome(char [] numberArray)
	{
		if(numberArray.length==1)
			return true;
		else
		{
			for(int i=0,j=numberArray.length-1 ;i<=j;i++,j--)
			{
//				/*Method return false if the array is not a palindrome.*/
				if(numberArray[i]!=numberArray[j])
					return false;
				
			}
			return true;
		}
	}
	
	private boolean isBase2Palindrome(int number)
	{
		char [] base2Format = Integer.toString(number, 2).toCharArray();
		
		if( isPalindrome(base2Format) )
			return true;
		else
			return false;
	}
	
	private long findDoublePalindromSum(int limit)
	{
		long sum=0;
		for(int i=1;i<=limit;i++)
		{
			System.out.println(i);
			if( isPalindrome( String.valueOf(i).toCharArray() ) && isBase2Palindrome(i))
			{
				sum+=i;
				System.out.println("i : "+i+"\t\t"+"sum : "+sum+"\t\t"+"Double Base Palindrome");
			}
			
			
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		int limit = 1000000;
		
		P36_DoubleBasePalindromes p36_DoubleBasePalindromes = new P36_DoubleBasePalindromes();
		long sum = p36_DoubleBasePalindromes.findDoublePalindromSum(limit);
		
		System.out.println("Sum of Double Base Palindromes under "+limit+" is "+sum);
		

	}

}
