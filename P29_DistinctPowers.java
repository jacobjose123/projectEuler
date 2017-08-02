package first26_50;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacobjose123
 *
 */
public class P29_DistinctPowers {
	
	
	private static int findDistinctElementCount(int limit)
	{
		Set<BigDecimal> distinctElementSet = new HashSet<BigDecimal>();
		
		for(int a=2;a<=limit;a++)
		{
			for(int b=2;b<=limit;b++)
			{
				distinctElementSet.add(new BigDecimal(String.valueOf(Math.pow(a, b))));
			}
		}
		return distinctElementSet.size();
		
	}
	

	public static void main(String[] args) {
		
		int limit = 100;
		
		System.out.println("Number of distinct terms 2<=a<="+limit+" & 2<=b<="+limit+" : "+findDistinctElementCount(limit));


	}

}
