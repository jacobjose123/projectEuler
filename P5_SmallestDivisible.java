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
public class P5_SmallestDivisible {

		private static long smallestDivisible; 
		private static final  int upperLimit =20;
		
		public static void main(String[] args) {
		
		 smallestDivisible = 1;
		 
		 /*FOLLOWING IS A BRUTE FORCE APPROACH*/
		 boolean divisibleByAll = false;
		 for(int i=0; ! divisibleByAll ;i=i+20)
		 {
			 divisibleByAll = checkIfDivisibleByAll(i);
			 System.out.println(i+" "+divisibleByAll);
		 }
		 
	}
		
		
		
		private static boolean checkIfDivisibleByAll(long num)
		{
			if(num<=0)
				return false;
			
			for(int i=1;i<=upperLimit;i++)
			{
				if(num%i!=0)
					return false;
			}
			
			return true;
		}

}
