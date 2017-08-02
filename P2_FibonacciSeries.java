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

//By considering the terms in the Fibonacci sequence 
//whose values do not exceed four million, find the sum of the even-valued terms
public class P2_FibonacciSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long first=1;
		long second = 2;
		long sum=second;
		
		System.out.print("1."+first+"\t "+"2."+second+"\t"+"Sum:"+sum+"\n");
		
		int i=3;
		while(second<=4000000)
		{
			
			long initialFirstValue = first;
			first=second;
			second = second+initialFirstValue;
			
			
			if(second%2==0)
				sum+=second;
			
			
//			System.out.printf("%d.%d \t %d.%d \t Sum:%d \n",i,first,i+1,second,sum);
			
			
			if(i%2!=0)
				System.out.printf("%d.%d",i,second);
			else
				System.out.printf("\t %d.%d \tSum:%d \n",i,second,sum);
			
			i++;
		}
		
		System.out.println("\nSum :"+sum);

	}

}
