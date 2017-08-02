/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

import java.math.BigInteger;

/**
 * @author a-7383
 *
 */
public class P9_SpecialPythagorianTriplet {
	
	private static int  a;
	private static int b;
	private static int c;
	private static final int  SUM = 1000;
	
	private static int square(int...num)
	{
		int square = 0;
		for(int i=0;i<num.length;i++)
		{
			square = square + (int)Math.pow(num[i],2);
		}
		
		return square;
	}
	
	public static void main(String[] args) {
		a = 1;
		b = 2;
		c = 3;
		
		int product=0;
		
		for(a=1; (a+b+c)<=SUM; a++)
		{
			for(b=a+1; b<c; b++)
			{
				for(c=b+1; a+b+c<=SUM; c++)
				{
					display();
					if((square(a)+square(b))==square(c) && a+b+c == SUM)
					{
						product = a*b*c;
					}
				}
			}
			b=a+2;
			c=b+1;
		}
		System.out.println("Product : "+product);
		
	}
	private static void display()
	{
		System.out.print(a+" + "+b+" + "+c+" = "+(a+b+c)+" || ");
		System.out.print(square(a)+square(b)+" | "+square(c)+"\n");

//		System.out.print(square(a)+" + "+square(b)+" = "+(square(a)+square(b))+" | "+square(c)+"\n");
	}

}
