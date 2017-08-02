/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author a-7383
 *
 */
public class P15_LatticePaths {
	
	private static final int GRID =50;
	
	
	private static Map<String,Long> routeMap = new HashMap<String, Long>();
	
	private static long findRouteCount(int row, int col)
	{
		
		System.out.println("Row : "+row+"\t\t\t"+"Col : "+col);
		if(row>GRID || col>GRID)
			return 0;
		else if(row==GRID && col== GRID)
		{
			return 1;
		}
		else
		{
			String currentPosition = row+"."+col;
			if(routeMap.containsKey(currentPosition))
				return routeMap.get(currentPosition);
			else
			{
				
				long rightCount = findRouteCount(row, col+1);
				long downCount = findRouteCount(row+1, col);
				
				long totalRoutes = rightCount+downCount;
				
				routeMap.put(currentPosition, totalRoutes);
				return totalRoutes;
			}
		}
	}
	

	public static void main(String[] args) {
		
		System.out.println(findRouteCount(0, 0));

	}

}
