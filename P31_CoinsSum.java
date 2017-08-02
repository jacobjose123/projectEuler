package first26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * @author jacobjose123
 *
 */
public class P31_CoinsSum {
	
	private static final List<Integer> COINS = new ArrayList<>(Arrays.asList(200,100,50,20,10,5,2,1));
	private static Map<Integer,Integer> coinMap = new HashMap<Integer, Integer>();
	private static Map<Integer,String> coinsMap = new HashMap<Integer,String>();
	
	private static final int [] coins = new int [] {5,2,1};
	
	private static int findCoinCombination(int number)
	{
		int count=0;
		for(int p200=number;p200>=0;p200-=200)
			for(int p100=p200;p100>=0;p100-=100)
				for(int p50=p100;p50>=0;p50-=50)
					for(int p20=p50;p20>=0;p20-=20)
						for(int p10=p20;p10>=0;p10-=10)
							for(int p5=p10;p5>=0;p5-=5)
								for(int p2=p5;p2>=0;p2-=2)
//									for(int p1=p2;p1>=0;p1-=1)
									{
										
											count++;
									}
		return count;
							
				
	}
	
	private static int findCoinCombinations(int number)
	{
		int count=0;
		int sum=0;
		int p1,p2;
		p1=p2=0;
		
		
		for(int p20=0;p20<=number;p20+=20)
		{
			for(int p10=0;p10<=number;p10+=10)
			{
				for(int p5=0;p5<=number;p5+=5)
				{
					
					if(sum<number) /*Penny 2*/
					{
						
						while(sum<=number)
						{
							if(sum<number) /*Penny 1*/
							{
								while(sum<=number)
								{
									if(sum==number)
									{
										System.out.print("1"+"\n");
										count++;
										sum=p2;
										break;
									}
									sum+=1;
								}
//								/*End of Penny 1*/
							}
							
							if(sum==number)
							{
								System.out.print("2"+"\n");
								count++;
								sum=p5;
								break;
							}
							sum+=2;
						}
//								/*End of Penny 2*/
					}
					if(sum==number)
					{
						System.out.println("p5 * "+p5+". ");
						count++;
						sum=p10;
						break;
					}
					sum+=5;
//					/*End of Penny 5*/
				}
				if(sum==number)
				{
					System.out.println("p10 * "+p10+". ");
					count++;
					sum=p10;
					break;
				}
				sum+=10;
//				/*End of Penny 10*/
			}
			if(sum==number)
			{
				System.out.println("p20 * "+p20+". ");
				count++;
				sum=p20;
				break;
			}
			sum+=20;
//			/*End of Penny 2*/
			
		}
		return count;
	}
	
	private static void displayMap()
	{
		System.out.println("Coins Map is :");
		for(Map.Entry<Integer, String> coin : coinsMap.entrySet())
		{
			System.out.println(coin.getKey()+" : "+coin.getValue());
		}
	}
	

	

	private static StringBuffer findCoins(int number)
	{
		StringBuffer combination = new StringBuffer();
		for(int i=0;i<coins.length;i++)
		{
			if(number-coins[i]==0)
				combination.append(coins[i]+",");
			else if(number-coins[i]>0)
				combination.append(String.valueOf(coins[i])+"+"+findCoins(number-coins[i]));
		
		}
		
		
		return combination;
		
	}
	
	private static int findWays(int number)
	{
//		System.out.println(number);
		
		if(number==0)
			return 0;
		else
		{
			int count=0;
			for(int i=0;i<COINS.size();i++)
			{
				
				int coin = COINS.get(i);
				int currentNumber = number-COINS.get(i);
				
				if(currentNumber<0)
				{
					
				}
				else if(currentNumber==0)
				{
					count++;
					
				}
				else if(currentNumber>0)
				{
					if(coinMap.containsKey(currentNumber))
						count=coinMap.get(currentNumber);
					else 
					{
//						System.out.println("findWays("+number+"-"+COINS.get(i)+")  : "+findWays(currentNumber));
						
						
						count+=findWays(currentNumber);
						
//						int currentCount = coinMap.get(currentNumber);
						
						
						
//						coinMap.put(currentNumber,count);
					}
				}
					
			}
			coinMap.put(number, count);
			return count;
		}
	}
	
	public static void main(String[] args) {
		
		int number = 200;
		
//		System.out.println("findWays("+number+")  : "+findWays(number));
//		System.out.println("No of ways of making "+number+" is : "+findWays(number));
//		System.out.println("FindCoins = "+findCoins(number));
		
//		System.out.println("findwaysString("+number+") : "+findWaysString(number));
//		displayMap();
		
//		System.out.println("findCoinCombinations("+number+") : "+findCoinCombinations(number));
		
		System.out.println("findCoinCombs("+number+") : "+findCoinCombination(number));
	

	}

}
