package first26_50;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * @author jacobjose123
 *
 */

/*
 * In this problem we have to read words from text file and check whether the word value of that number is a triangle number. And then
 * return the count of triangle numbers.
 * 
 * Note:
 * Please change the file path in the method 'getWordsListFromFile()' in case you are using a different IDE
 */

public class P42_CodedTriangleNumbers {
	
	private static void displayArray(char...arr)
	{
		for(char ar:arr)
			System.out.print(ar);
		System.out.println("");
	}
	
	
//	/*This method will read from file in the Eclipse bin folder and then will return an array containing the words*/
	private String [] getWordsListFromFile()
	{
		String [] wordsArray = null;
		try
		{
			String filePath = "resources/P42_CodedTriangleNumbers.txt";
			ClassLoader classLoader =  P42_CodedTriangleNumbers.class.getClassLoader();
			File file = new File(classLoader.getResource(filePath).getFile());
			BufferedReader br = new BufferedReader(new FileReader(file));	
			
			String inputWord = br.readLine();
			
			
			if(inputWord!=null)
			{
				System.out.println(inputWord);
//				/*We are reading the substring to trim out the double quotes ("")*/
				wordsArray = inputWord.split(",");
			}
			
			br.close();
			
		}
		catch(Exception e)
		{
			System.out.println("An Exception has occured."+"\n");
		}
		
		return wordsArray;
	}

//	/*This method will return the word value of a number inputed.*/
	private int getWordValue(String word)
	{
//		/*We are trimming the double quotes from the two ends of the word and then converting the word into a char array*/
		char [] charactersArray = word.substring(1, word.length()-1).toCharArray();
		int wordValue = 0;
		
		
//		/*We are substracting the ASCII value of each alphabet to get the index*/
		for(int i=0;i<charactersArray.length;i++)
			wordValue+=(charactersArray[i]-64);
		
		return wordValue;
	}

//	/*This method will tell whether the arguement number is a triangle number or not*/
	private boolean isTriangleWord(int wordValue)
	{
		int j=0;
		/*
		 *The following is a possible because formula to find the n-th Triangle number is the same as the 
		 *formula to find the sum of n natural numbers.
		 */
		
		for(int i=0;j<wordValue;i++)
			j+=i;
		
		if(wordValue==j)
			return true;
		else
			return false;
	}

//	/*This number will return the number of triangle words in the text file specified.*/
	public int getTriangleWordCount()
	{
		String []  wordsFromFile = getWordsListFromFile();
		int count =0;
		
		for(String word : wordsFromFile)
		{
			
			if( isTriangleWord(getWordValue(word)) )
			{
				count++;
				System.out.println(word+"\t\t"+"Count : "+count);
			}
			else
				System.out.println(word);
		}
		return count;
	}
	
	public static void main(String[] args) {

		P42_CodedTriangleNumbers p42_CodedTriangleNumbers = new P42_CodedTriangleNumbers();
		
		System.out.println("Number of triangle words : "+p42_CodedTriangleNumbers.getTriangleWordCount());
		
		
	}

}
