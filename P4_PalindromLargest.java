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
public class P4_PalindromLargest {

	private static boolean isPalindrome(int num)
	{
//		StringBuffer br = new StringBuffer(String.valueOf(num));
//		StringBuffer brRev = new StringBuffer(String.valueOf(num));
//		brRev.reverse();
//		if(br.equals(brRev))
//			return true;
//		
//		else
//			return false;
		
		char [] digits = String.valueOf(num).toCharArray();
		for(int i=0,j=digits.length-1;i<j;i++,j--)
		{
			if(digits[i]!=digits[j])
				return false;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		
		int i = 0;
		int largestPalindrome = 0;
		for(i=999;i>99;i--)
		{
			for(int j=i-1;j>99;j--)
			{
				int product = i*j;
				if(isPalindrome(product))
				{
					if(product>largestPalindrome)
					{
						largestPalindrome=product;
						System.out.println(i+" * "+j+" = "+ product);
						break;
					}
					
				}

			}
			
		}
		
		System.out.println("i : "+i);

		
	}

}
