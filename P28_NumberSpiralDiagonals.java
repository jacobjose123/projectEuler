package first26_50;

/**
 * @author jacobjose123
 *
 */
public class P28_NumberSpiralDiagonals {
	
	private static long findSum (int gridSize)
	{
		if(gridSize>1)
		{
			long sumUpperRight,sumUpperLeft,sumLowerLeft,sumLowerRight;
			sumUpperRight=sumUpperLeft=sumLowerLeft=sumLowerRight=0;
			for(int currentGrid=3;currentGrid<=gridSize;currentGrid+=2)
			{
//				/*Calculating the upper right element*/
				long cornerElement = currentGrid*currentGrid;
				sumUpperRight+= cornerElement;
				
				cornerElement-=(currentGrid-1);
				sumUpperLeft+=cornerElement;
				
				cornerElement-=(currentGrid-1);
				sumLowerLeft+=cornerElement;
				
				cornerElement-=(currentGrid-1);
				sumLowerRight+=cornerElement;
			}
			
			return sumUpperRight+sumUpperLeft+sumLowerLeft+sumLowerRight+1;
		}
		else
			return 1;
	}

	public static void main(String[] args) {
		
		int gridSize = 1001;
		
		System.out.println("Sum of diagonals of "+gridSize+"x"+gridSize+" grid is : "+findSum(gridSize));

	}

}
