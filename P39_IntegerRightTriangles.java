package first26_50;

/**
 * @author jacobjose123
 *
 */
public class P39_IntegerRightTriangles {
	
	public int findMaxTriangleCountPerimeter(int maxPerimeterLimit)
	{
		int maxTrianglesCount =0;
		int maxTriangleCountPerimeter =0;
		for(int i=3;i<=maxPerimeterLimit;i++)
		{
			int trianglesCount = findMaxTrianglesCount(i);
			
			if(trianglesCount>maxTrianglesCount)
			{
				maxTrianglesCount = trianglesCount;
				maxTriangleCountPerimeter = i;
				
			}
		}
		return maxTriangleCountPerimeter;
	}
	
//	/*This method attempts to find the solution using Raw Brute Force*/
	private int findTriangleCount(int perimeter)
	{
		int count =0;
		
		for(int i=1;i<perimeter;i++)
		{
			for(int j=1;i+j<=perimeter;j++)
			{
				for(int k=1;i+j+k<=perimeter;k++)
				{
					
					System.out.println("i : "+i+"\t\t"+" j : "+j+"\t\t"+" k : "+k+"\t\t"+" Perimeter : "+perimeter);
					if( i+j+k==perimeter && i*i== j*j+k*k ) 
					{
						count++;
						System.out.println("i : "+i+"\t\t"+" j : "+j+"\t\t"+" k : "+k+"\t\t"+" Perimeter : "+perimeter+"\t\t"+"Right Triangle"+"\t\t"+" count : "+count);
						
						
					}
				}
			}
		}
		
//		/*Here we are dividing by 2 since, the for loops will be generating 2 rows with the same values and we only need 1.*/
		return count/2;
	}

//	/*The following method is an optimized Brute force Method to find number of triangles with specified perimeter.*/
	private int findMaxTrianglesCount(int perimeter)
	{

		int count=0;
		
		int i=1;
		int j=i+1;
		int k = perimeter-i-j;
		
		for(i=1;i<perimeter;i++)
		{
			k=perimeter-i-i;
			
			for(j=i+1;j<k;j++)
			{
				k=perimeter-j-i;
				
				System.out.println("i : "+i+"\t\t"+" j : "+j+"\t\t"+" k : "+k+"\t\t"+" Perimeter : "+perimeter);
				
				if(k<0)
					break;
				else if ( k*k==(i*i+j*j) )
				{
					count++;
					System.out.println("i : "+i+"\t\t"+" j : "+j+"\t\t"+" k : "+k+"\t\t"+" Perimeter : "+perimeter+"\t\t"+"Right Triangle"+"\t\t"+" count : "+count);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {

		P39_IntegerRightTriangles p39_IntegerRightTriangles = new P39_IntegerRightTriangles();
		
		int perimeterLimit = 1000;
		int count = p39_IntegerRightTriangles.findMaxTriangleCountPerimeter(perimeterLimit);
		
		System.out.println("Number of Integer Triangle under Perimeter "+perimeterLimit+" : "+count);
	}

}
