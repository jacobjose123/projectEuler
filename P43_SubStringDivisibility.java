package first26_50;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacobjose123
 *
 */
public class P43_SubStringDivisibility {
	

	
//	/*This method checks whether the arguement number is prime or not.*/
	private boolean isPanDigit(long number)
	{
		
		if(number == 247503689)
			System.out.println("Condition Met");
		
		char [] digits = String.valueOf(number).toCharArray();
		
		
		
		List<Character> digitsList = new ArrayList<Character>(Arrays.asList('1','2','3','4','5','6','7','8','9','0'));
		
		for(char digit: digits)
		{
			if( !(digitsList.contains(digit)) )
				return false;
			else
			{
				digitsList.remove(Character.valueOf(digit));
			}
		}
		if(digitsList.size()==0)
			return true;
		else
			return false;
		
	}

//	/*This method checks whether the number satisfies the condition in the question or not.*/
	private boolean isSubStringDivisible(StringBuffer number)
	{
		
		
//		/*Checking whether the number with digits from d2-d3-d4 is divisible by 2*/
		int digits = Integer.valueOf(number.substring(1, 4));
		
		if( digits % 2 != 0 )
			return false;
		
//		/*Checking whether the number with digits from d3-d4-d5 is divisible by 3*/
		digits = Integer.valueOf(number.substring(2, 5));
		if( digits % 3 != 0 )
			return false;
		
//		/*Checking whether the number with digits from d4-d5-d6 is divisible by 5*/
		digits = Integer.valueOf(number.substring(3, 6));
		if( digits % 5 != 0 )
			return false;
		
//		/*Checking whether the number with digits from d5-d6-d7 is divisible by 7*/
		digits = Integer.valueOf(number.substring(4, 7));
		if( digits % 7 != 0 )
			return false;
		
//		/*Checking whether the number with digits from d6-d7-d8 is divisible by 11*/
		digits = Integer.valueOf(number.substring(5, 8));
		if( digits % 11 != 0 )
			return false;
		
//		/*Checking whether the number with digits from d7-d8-d9 is divisible by 13*/
		digits = Integer.valueOf(number.substring(6, 9));
		if( digits % 13 != 0 )
			return false;
		
//		/*Checking whether the number with digits from d8-d9-d10 is divisible by 17*/
		digits = Integer.valueOf(number.substring(7, 10));
		if( digits % 17 != 0 )
			return false;
		
		
//		/*If all the above conditions are satisfied return true.*/
		return true;
		
		
		
		

	}


	/*
	 * This method will generate 9 digit pan digit number, 
	 * checks whether the number satisfies the Sub-String Divisivility Condition
	 * and then return the sum of all those pandigit numbers.
	 */
			
	private long getPanDigitNumbersSum()
	{
		long sum=0;
		List<Integer> currentDigitsList = new ArrayList<Integer>();
		for(int first=0; first<=9 ; first++ )
		{
			currentDigitsList.add(first);
			for(int second=0 ; second<=9 ; second++ )
			{
				if( !(currentDigitsList.contains(second)) )
				{
					currentDigitsList.add(second);
					for(int third=0 ; third<=9 ; third++ )
					{
						if( !(currentDigitsList.contains(third)) )
						{
							currentDigitsList.add(third);
							for(int four=0 ; four<=9 ; four++ )
							{
								if( !(currentDigitsList.contains(four)) )
								{
									currentDigitsList.add(four);
									for(int five=0 ; five<=9 ; five++ )
									{
										if( !(currentDigitsList.contains(five)) )
										{
											currentDigitsList.add(five);
											for(int six=0 ; six<=9 ; six++ )
											{
												if( !(currentDigitsList.contains(six)) )
												{
													currentDigitsList.add(six);
													for(int seven=0 ; seven<=9 ; seven++ )
													{
														if( !(currentDigitsList.contains(seven)) )
														{
															currentDigitsList.add(seven);
															for(int eight=0 ; eight<=9 ; eight++ )
															{
																
																if( !(currentDigitsList.contains(eight)) )
																{
																	currentDigitsList.add(eight);
																	for(int nine=0 ; nine<=9 ; nine++ )
																	{
																		
																		if( !(currentDigitsList.contains(nine)) )
																		{
																			currentDigitsList.add(nine);
																			for(int ten=0 ; ten<=9 ; ten++ )
																			{
																			
																				if( !(currentDigitsList.contains(ten)) )
																				{
		
																					StringBuffer number = new StringBuffer("");
																					number.append(Integer.valueOf(first));
																					number.append(Integer.valueOf(second));
																					number.append(Integer.valueOf(third));
																					
																					number.append(Integer.valueOf(four));
																					number.append(Integer.valueOf(five));
																					number.append(Integer.valueOf(six));
																					
																					number.append(Integer.valueOf(seven));
																					number.append(Integer.valueOf(eight));
																					number.append(Integer.valueOf(nine));
																					
																					number.append(Integer.valueOf(ten));
																					
																					System.out.println(number+"\t\t"+"Sum : "+sum);
																					
																					if(isPanDigit(Long.valueOf(number.toString())) && isSubStringDivisible(number))
																						sum+=Long.valueOf(number.toString());
																				}
																			}
																		
																			/*Removing the Ninth Digit*/
																			currentDigitsList.remove(currentDigitsList.size()-1);
																	}
																	}
//																	/*Removing the Eight Digit*/
																	currentDigitsList.remove(currentDigitsList.size()-1);
																	
																}
															}
//															/*Removing the Seventh Digit*/
															currentDigitsList.remove(currentDigitsList.size()-1);
														}
													}
//													/*Removing the Sixth Digit*/
													currentDigitsList.remove(currentDigitsList.size()-1);
												}
											}
//											/*Removing the Fifth Digit*/
											currentDigitsList.remove(currentDigitsList.size()-1);
										}
									}
//									/*Removing the Fourth Digit*/
									currentDigitsList.remove(currentDigitsList.size()-1);
								}
							}
//							/*Removing the Third Digit*/
							currentDigitsList.remove(currentDigitsList.size()-1);
						}

						
					}
					/*Removing the Second Digit*/
					currentDigitsList.remove(currentDigitsList.size()-1);
				}
				
			}
			/*Clearing the currentDigitsList */
			currentDigitsList.clear();
		}
		
		return sum;
		
	}
	
	public static void main(String[] args) {

		P43_SubStringDivisibility p43_SubStringDivisibility = new P43_SubStringDivisibility();
		
		System.out.println("Sum of PanDigit numbers is : "+p43_SubStringDivisibility.getPanDigitNumbersSum());
		
//		System.out.println(p43_SubStringDivisibility.isSubStringDivisible(new StringBuffer("1406357289")));
	}

}
