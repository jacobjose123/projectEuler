package first25;

/**
 * @author jacobjose123
 *
 */
public class P24_LexicographicPermutations {

	private static final int SIZE = 10;
	
	private static int [] digits = new int [] {0,1,2,3,4,5,6,7,8,9};
	
	private static boolean generateNext()
	{
		int k=-1,l=-1;
//		/*Generating the value of k*/
		for(int i=SIZE-2;i>=0;i--)
		{
			if(digits[i]<digits[i+1])
			{
				k=i;
				break;
			}
		}
		
		for(int i=SIZE-1; i>k && k>-1 ;i--)
		{
			if(digits[i]>digits[k])
			{
				l=i;
				break;
			}
		}
		
		if(k>-1 && l>-1)
		{
			swap(k,l);
			reverse(k+1);
//			displayDigits();
			return true;
		}
		else
		{
//			displayDigits();
			return false;
		}
	}
	
	private static void reverse(int k)
	{
		if(k==SIZE-1)
			return;
		
		int [] reversedDigits =digits.clone();
		
		for(int i=k,j=SIZE-1;i<SIZE;i++,j--)
			reversedDigits[i]=digits[j];
		
		digits = reversedDigits;
	}
	
	private static void swap(int k, int l)
	{
		if(k==l)
			return;
		
		int digit =digits[k];
		digits[k] = digits[l];
		digits[l]= digit;
	}
	
	private static void displayDigits()
	{
		for(int i=0;i<SIZE;i++)
			System.out.print(digits[i]+" ");
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		

		int i=1;
		System.out.print(i+". ");
		displayDigits();
		
		while(generateNext())
		{
			i++;
			System.out.print(i+". ");
			displayDigits();
			
//			if(i==1000000)
//				break;
		}
		
		System.out.println(i+" term is : ");
		displayDigits();
		
		
		
		
	}

}
