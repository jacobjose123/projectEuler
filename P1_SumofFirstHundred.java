/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

import java.util.Scanner;

/**
 * @author a-7383
 *
 */
public class P1_SumofFirstHundred {
	
	public static void main (String [] args)
	{
		int sum=0;
		for(int i=3;i<1000;i++)
		{
			if(i%3==0)
				sum=sum+i;
			else if(i%5==0)
				sum+=i;
		}
		System.out.println(sum);
	}
	
	
	
	

}
