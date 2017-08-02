package first25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacobjose123
 *
 */
public class P22_NameScores {
	
	private static List<String> nameList;
	
	private static long caculateListNameScore()
	{
		long listScore =0;
		for(int i=0;i<nameList.size();i++)
		{
			listScore+=(calculateNameScore(nameList.get(i))*(i+1));
			System.out.println(i+". "+nameList.get(i)+" Name Score : "+calculateNameScore(nameList.get(i))+" Total Score : "+listScore);
		}
		
		return listScore;
	}
	
	
	private static long calculateNameScore(String name)
	{
		int nameCharSum=0;
		char [] nameChars = name.toCharArray();
		
		for(int i=0;i<nameChars.length;i++)
			nameCharSum+=(nameChars[i]-64);
		
		return nameCharSum;
	}
	
	private static void displayNames()
	{
		for(int i=0;i<nameList.size();i++)
			System.out.println(i+". "+nameList.get(i));
	}
	
	private static void readFromFile(String filePath)
	{
		nameList = new ArrayList<String>();
		
		try 
		{
		ClassLoader classLoader = new P22_NameScores().getClass().getClassLoader();
		File file = new File(classLoader.getResource(filePath).getFile());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		
		String inputLine = br.readLine(); 
		inputLine = inputLine.replaceAll("\"", "");
		String [] namesArray = inputLine.split(",");
		
		for(int i=0;i<namesArray.length;i++)
		{
			nameList.add(namesArray[i]);
			
		}
		
		System.out.println("Names List Before Sorting");
		displayNames();
		
		Collections.sort(nameList);
		
		System.out.println("Names List After Sorting");
		displayNames();
		
		br.close();
		fr.close();
		
		
		
		} 
		catch (Exception e) 
		{
		
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		
		readFromFile("resources/P22_NameScores.txt");
		System.out.println("Total List Score : "+caculateListNameScore());

	}

}
