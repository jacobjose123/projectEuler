/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;

/**
 * @author a-7383
 *
 */
public class P13_LargeSum {

	
	private static BigInteger [] numbers ;
	private static BigInteger sum;
	
	private static void initialize()
	{
		try
		{
//			/*Please ensure that the file is put INSIDE THE BIN FOLDER*/
	        String fileName = "resources/LargeSum_Numbers.txt";
	        ClassLoader classLoader = new P13_LargeSum().getClass().getClassLoader();
	        File file = new File(classLoader.getResource(fileName).getFile());
	        
	        
//			File file = LargeSum.class.getResourceAsStream("resources/LargeSum_Numbers.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			numbers= new BigInteger [500];
			sum = new BigInteger("0");
			
			String inputNumber = br.readLine();
			
			int i=0;
			while(inputNumber!=null)
			{
				numbers[i]= new BigInteger(inputNumber);
				sum= sum.add(numbers[i]);
				
				
				
				System.out.println(i+". "+sum+"(sum) : "+numbers[i]+"(number)");
				inputNumber = br.readLine();
				i++;
			}
			
			br.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}
	public static void main(String[] args) {
		
		initialize();
		System.out.println("Required Sum is : "+sum);
		System.out.println("Size of Sum is : "+sum.toString().length());
		System.out.println("First 10 digits : "+sum.toString().substring(0, 10));
	}

}
