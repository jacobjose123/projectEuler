/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author a-7383
 *
 */
public class P17_NumberLetterCounts {
	
	private static final int LIMIT = 1001;
	private static Map<Integer,String> numberMap ;
	
	
	
	private static StringBuffer convertToString(int num)
	{
		StringBuffer result = new StringBuffer() ;
		if(numberMap.containsKey(num))
			return new StringBuffer(numberMap.get(num));
		else if(num<100)
		{
			int tens = (num/10)*10;
			int ones = num%10;
			result = convertToString(tens);
			result = result.append(" ");
			result = result.append(convertToString(ones));
		}
		else if(num<1000)
		{
			int hundreds = num/100;
			int tens = num%100;
			result = convertToString(hundreds);
			if(tens>0)
				result = result.append(" hundred and ");
			else
				result = result.append(" hundred" );
			result = result.append(convertToString(tens));
		}
		else if(num<100000)
		{
			int thousands = num/1000;
			int hundreds = num%1000;
			result = convertToString(thousands);
			result = result.append(" thousand ");
			result = result.append(convertToString(hundreds));
		}
		else if(num<1000000)
		{
			int thousands = num/100000;
			int hundreds = num%100000;
			result = convertToString(thousands);
			result = result.append(" hundred thousand ");
			result = result.append(convertToString(hundreds));
		}
		
		
		
		
		return result;
	}

	private static boolean initializeNumberMap()
	{
		BufferedReader br ;
		try
		{
			
			numberMap = new HashMap<Integer, String>();
			
//			/*Please ensure that the file is put INSIDE THE BIN FOLDER*/
			String fileName = "resources/P17_NumberLetterCounts.txt";
			ClassLoader classLoader = new P17_NumberLetterCounts().getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			FileReader fr = new FileReader(file);
			
			br = new BufferedReader(fr);
			
			String initalData = br.readLine();
			while(initalData!=null && !initalData.equals(""))
			{
				
//				System.out.println(initalData);
				
				int hyphenIndex = initalData.indexOf("-");
				int digitKey = Integer.valueOf(initalData.substring(0,hyphenIndex));
				String stringValue = initalData.substring(hyphenIndex+1,initalData.length());
				numberMap.put(digitKey,stringValue);
				
				initalData = br.readLine().trim();
				
			};
			
			
			
			
			br.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;

	}
	public static void main(String[] args) {
		
		long count =0;
		if(initializeNumberMap())
		{
			for (int i = 1; i < LIMIT; i++) 
			{
				String result = convertToString(i).toString();
				System.out.print(i+" . "+convertToString(i));
				
				result =result.replaceAll("\\s","");
				count = count+result.length();
				
				System.out.print(" \""+result+"\" ("+result.length()+")");
				System.out.print("\t Count = "+count);
				System.out.println("");
			}
			
			
//			String result = convertToString(115).toString();
//			result = result.replaceAll("\\s", "");
//			System.out.println(result+" "+result.length());

		}

	}

}
