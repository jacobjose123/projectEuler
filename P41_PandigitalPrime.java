package first26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacobjose123
 *
 */

/*
 * We know that the if  sum of the digits of a number is divisible by 3 then that number is also divisible
 * by 3. Since a prime number's only factor is that number and 1.
 * 
 * We can ignore pan digit numbers of lengths 1,2,3,5,6,8,9 since sum of the digits of those number are divisible
 * by 3 and hence those number will be divisible by 3. 
 */
public class P41_PandigitalPrime {
	
//	/*Here we are considering a pandigit number of length 7 only.*/
	private int findPrimeNumber()
	{
		List<Integer> currentDigitsList = new ArrayList<Integer>();
		
//		/*The possible last digits of a prime number is 1,3,5*/
		List<Integer> lastDigitsList = new ArrayList<Integer>(Arrays.asList(1,3,7));
		
		for(int a = 7;a>0;a--)
		{
			currentDigitsList.add(a);
			for(int b = 7;b>0   ;b--)
			{
				if((currentDigitsList.contains(b)) )
					continue;
				
				currentDigitsList.add(b);
				
				for(int c = 7;c>0;c--)
				{
					if((currentDigitsList.contains(c)) )
						continue;
					
					currentDigitsList.add(c);
					for(int d = 7;d>0  ;d--)
					{
						if((currentDigitsList.contains(d)) )
							continue;
						
						currentDigitsList.add(d);
						for(int e = 7;e>0 ;e--)
						{
							if((currentDigitsList.contains(e)) )
								continue;
							
							currentDigitsList.add(e);
							for(int f = 7;f>0  ;f--)
							{
								if((currentDigitsList.contains(f)) )
									continue;
								
								currentDigitsList.add(f);
								for(int lastDigit : lastDigitsList)
								{
									if( !(currentDigitsList.contains(lastDigit)) )
									{
										StringBuffer number = new StringBuffer(7);
										number.append(Integer.toString(a));
										number.append(Integer.toString(b));
										number.append(Integer.toString(c));
										number.append(Integer.toString(d));
										number.append(Integer.toString(e));
										number.append(Integer.toString(f));
										number.append(Integer.toString(lastDigit));
										
										int sevenDigitNumber = Integer.valueOf(number.toString());
										
										if( isPanDigit(sevenDigitNumber) && isPrime(sevenDigitNumber))
											return sevenDigitNumber;
											
										
									}
//									currentDigitsList.remove(currentDigitsList.size()-1);
								}
								currentDigitsList.remove(currentDigitsList.size()-1);
								
							}
							currentDigitsList.remove(currentDigitsList.size()-1);
							
							
						}
						currentDigitsList.remove(currentDigitsList.size()-1);
						
						
					}
					currentDigitsList.remove(currentDigitsList.size()-1);
					
					
				}
				currentDigitsList.remove(currentDigitsList.size()-1);
				
			}
			currentDigitsList.clear();
		}
		return 0;
	}

	
	private boolean isPanDigit(int number)
	{
		char [] digits = String.valueOf(number).toCharArray();
		
		
		
		List<Character> digitsList = new ArrayList<Character>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
		
		for(char digit: digits)
		{
			if( !(digitsList.contains(digit)) )
				return false;
			else
			{
				
				digitsList.remove(Character.valueOf(digit));
				
			}
		}
		return true;
		
	}
	
	private boolean isPrime(int number)
	{
		
		if(number%2==0 || number%3== 0)
			return false;
		else
		{
			for(int i=3;i<=Math.sqrt(number);i+=2)
			{
				if(number%i==0)
					return false;
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		
		
		P41_PandigitalPrime p41_PandigitalPrime = new P41_PandigitalPrime();
		

		System.out.println("PanDigit Prime Number is : "+p41_PandigitalPrime.findPrimeNumber());
	}

}
