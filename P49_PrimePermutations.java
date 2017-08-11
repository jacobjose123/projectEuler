package first26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacobjose123
 *
 */
public class P49_PrimePermutations {
	
//	/*This Method is to check whether the number input is a prime number or a composite number.*/
	private boolean isPrime(int number)
	{
		if(number%2==0)
			return false;
		else
		{
			for(int i=3;i<=Math.sqrt(number);i++)
			{
				if(number % i ==0 )
					return false;
			}
			
			return true;
					
		}
	}

//	/*This method will tell us whether the Second arguement number is a permutation of the first.*/
	private boolean isPermutationOfFirst(int number1, int number2)
	{
		List<Integer> number1CharacterList = new ArrayList<Integer>();
		
		char [] number1CharacterArray = String.valueOf(number1).toCharArray();
		
		for(char character: number1CharacterArray)
			number1CharacterList.add(Integer.valueOf(character));
		
		char [] number2CharacterArray = String.valueOf(number2).toCharArray();
		
		for(char character: number2CharacterArray)
		{
			if(number1CharacterList.contains(Integer.valueOf(character)))
				number1CharacterList.remove(Integer.valueOf(character));
			else
				return false;
		}
		
		return true;
		
		
	}
	
//	/*This method will return a string that will contain the 3 permutation numbers combined.*/  
	private String findPrimePermutationSequence(int startingTerm)
	{
		String combinationString = "";
		
		for(int firstTerm=startingTerm;firstTerm<=6770;firstTerm++)
		{
			if( isPrime(firstTerm))
			{
				int secondTerm = firstTerm+3330;
				
				if( isPrime(secondTerm) && isPermutationOfFirst(firstTerm, secondTerm))
				{
					int thirdTerm = secondTerm + 3330;
					
					if( isPrime(thirdTerm) && isPermutationOfFirst(secondTerm, thirdTerm))
					{
						
						combinationString=combinationString+firstTerm+secondTerm+thirdTerm;
						System.out.println(firstTerm+" "+secondTerm+" "+thirdTerm);
						break;
					}
				}
			}
			
			int secondTerm = firstTerm+3330;
			
			
		}
		
		return combinationString;
	}
	
	public static void main(String[] args) {

		P49_PrimePermutations p49_PrimePermutations = new P49_PrimePermutations();
		
//		/*We are starting from 1488 since it has already been specified in question that we need to find the number after 1487.1487*/
		System.out.println("The Next Combination term is : "+p49_PrimePermutations.findPrimePermutationSequence(1488));
		
	}

}
