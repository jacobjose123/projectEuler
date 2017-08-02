/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author a-7383
 *
 */
public class P67_MaximumPathSum2 {


	
	private static final int HEIGHT = 100;
	private static int [][] tree ;
	private static final String FILE_PATH ="resources/P67_MaximumPathSum2.txt";
	private static Map<String,Integer> map;
	
	private static void readFile(String filePath)
	{
		try
		{
			ClassLoader classLoader = new P18_MaximumPathSum().getClass().getClassLoader();
			File file = new File(classLoader.getResource(filePath).getFile());
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			tree = new int [HEIGHT][HEIGHT];
			
			for(int i=0;i<HEIGHT;i++)
			{
				String [] input = br.readLine().split(" ");
				for(int j=0;j<=i;j++)
				{
					tree[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			map = new HashMap<String, Integer>();
			
			br.close();
			fr.close();
			
			
			
		}
		catch(Exception e)
		{
			tree = new int[HEIGHT][HEIGHT];
			e.printStackTrace();
		}
	}
	
	private static void display()
	{
		for(int i=0;i<HEIGHT;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(tree[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	private static int findSum(int row, int col)
	{
		if(row>HEIGHT || col>HEIGHT)
			return 0;
		else if(map.containsKey(row+"."+col))
			return map.get(row+"."+col);
		else if(row+1<HEIGHT)
		{
			int left = findSum(row+1, col);
			int right = findSum(row+1, col+1);
			left += tree[row][col];
			right += tree[row][col];
			
			int greatest = left>right?left:right;
			
			map.put(row+"."+col, greatest);
			return greatest;
		}
		else if(row==HEIGHT-1)
		{
			map.put(row+"."+col, tree[row][col]);
			return tree[row][col];
		}
		else
			return 0;
	}
	
	public static void main(String[] args) {
		
		
		readFile(FILE_PATH);
		display();
		
		System.out.println("Sum : "+findSum(0, 0));

	}
	
	


}
