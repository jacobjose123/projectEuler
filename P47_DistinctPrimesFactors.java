package first26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author jacobjose123
 *
 */
public class P47_DistinctPrimesFactors {
	
	
//	/*This Method is to check whether the number input is a prime number or a composite number.*/
	private boolean isPrime(int number)
	{
		if(number%2==0 )
			return true;
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
	
//	/*This method will return the factors optimized.Eg. 2*2*2 will be replaced by 8.*/
	private List<Integer> optimizeList(List<Integer> initialList)
	{
		List<Integer> optimizedList = new ArrayList<Integer>();
		
		Map<Integer,Integer> elementPowerMap = new HashMap<Integer,Integer>();
		for(int initialListElement : initialList)
		{
			if( !(elementPowerMap.containsKey(initialListElement)) )
				elementPowerMap.put(initialListElement, 1);
			else
			{
				int currentCount = elementPowerMap.get(initialListElement);
				elementPowerMap.put(initialListElement, ++currentCount);
			}
		}
		
		Iterator<Entry<Integer, Integer>> iterator = elementPowerMap.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry<Integer, Integer> mapEntry = (Map.Entry<Integer, Integer>)iterator.next();
			int element = mapEntry.getKey();
			int elementPower = mapEntry.getValue();
			
			int finalElement = (int)Math.pow(element, elementPower);
			
			optimizedList.add(finalElement);
		}
		return optimizedList;
	}
	
//	/*This method will find the factors of a number and then will return the factors as a List.*/
	private List<Integer> findFactorsList (int number)
	{
		List<Integer> factorsList = new ArrayList<Integer>();
		
		int i=2;
		while(number>1)
		{
			
			if( isPrime(i) && (number % i == 0 ) )
			{
				factorsList.add(i);
				number/=i;
			}
			else
				i++;
		}
		
		return optimizeList(factorsList);
	}

//	/*This Methods checks whether 2 lists are unique or not. If unique it returns true.*/
	private boolean areUniqueListsOfSameSize( List<Integer> biggerList,List<Integer> smallerList)
	{
		for(int smallerListElement:smallerList)
		{
			if(biggerList.contains(smallerListElement))
				return false;
		}
		return true;
	}
	
//	/*This method will check if there are unique prime factors for each of the consecutive elements, if yes it will return true.*/ 
	private boolean isHavingDistinctElements(List<Integer> factorsList1,List<Integer> factorsList2,List<Integer> factorsList3,List<Integer> factorsList4)
	{

		int commonListSize = 4;
		
		
		if( factorsList1.size()!=commonListSize || factorsList2.size()!=commonListSize || factorsList3.size()!=commonListSize || factorsList4.size()!=commonListSize )
			return false;
		else
		{
			List<Integer> allFactorsList = new ArrayList<Integer>();
			
			allFactorsList.addAll(factorsList1);
			
			if(areUniqueListsOfSameSize(allFactorsList, factorsList2))
				allFactorsList.addAll(factorsList2);
			else
				return false;
			
			if(areUniqueListsOfSameSize(allFactorsList, factorsList3))
				allFactorsList.addAll(factorsList3);
			else
				return false;
			
			if(areUniqueListsOfSameSize(allFactorsList, factorsList4))
				allFactorsList.addAll(factorsList4);
			else
				return false;
			
//			/*If all the lists are unique then this method will return true.*/ 
			return true;
		}
	}
	

//	/*This is the public method that will return the consecutive number with the required number of prime factors*/
	public int findFirstNumberOfSequence()
	{
		
		
		int startTerm =1;
		
		List<Integer> firstFactorsList = findFactorsList(startTerm);
		List<Integer>  secondfactorsList = findFactorsList(startTerm+1);
		List<Integer>  thirdFactorsList = findFactorsList(startTerm+2);
		List<Integer>  fourthfactorsList = findFactorsList(startTerm+3);
		
		int fourthNumber = startTerm+4;
		
		for(;;fourthNumber++)
		{
			if(isHavingDistinctElements(firstFactorsList, secondfactorsList, thirdFactorsList, fourthfactorsList))
				break; 
			else
			{
				firstFactorsList.clear();
				firstFactorsList.addAll(secondfactorsList);
				
				secondfactorsList.clear();
				secondfactorsList.addAll(thirdFactorsList);
				
				thirdFactorsList.clear();
				thirdFactorsList.addAll(fourthfactorsList);
				
				fourthfactorsList.clear();
				fourthfactorsList.addAll(findFactorsList(fourthNumber));
				
				System.out.print(fourthNumber+"\t");
				System.out.print(firstFactorsList.size()+" "+secondfactorsList.size()+" "+thirdFactorsList.size()+" "+fourthfactorsList.size()+"\n");
			}
		}
		
		
		return fourthNumber-4;
	}
	
	
//	/*This method is just to print an ArrayList.*/
	public static void displayList(List<Integer> list)
	{
		for(int i:list)
			System.out.print(i+" ");
		
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		P47_DistinctPrimesFactors p47_DistinctPrimesFactors = new P47_DistinctPrimesFactors();
		System.out.println("First Number of the sequence is : "+p47_DistinctPrimesFactors.findFirstNumberOfSequence());;

	
		
	}

}

class OldClass
{
	
}
