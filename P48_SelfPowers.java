package first26_50;

import java.math.BigInteger;

/**
 * @author jacobjose123
 *
 *	
 */

public class P48_SelfPowers {

//	/*This number will find the result of the power of a number.*/
	private BigInteger findPower(int term,int power)
	{
		BigInteger number = new BigInteger(String.valueOf(term));
		
		BigInteger powerTerm = new BigInteger("1");
		
		for(int i=0;i<power;i++)
			powerTerm = powerTerm.multiply(number);
		
		return powerTerm;
		
		
		
	}
	
//	/*This method will find the sum of numbers upto power n.*/
	private BigInteger findPowerUptoN(int n)
	{
		BigInteger finalTerm = new BigInteger("0");
		
		for(int i=1;i<=n;i++)
			finalTerm = finalTerm.add(findPower(i, i));
		
		return finalTerm;
	}
	

//	/*This method will return the 'n' number of digits of the final answer. The final answer is the sum of the powers.*/
	private String getLastNTermsOfPowerN(int n, int lastNoOfDigits)
	{
		String finalTerm = findPowerUptoN(n).toString();
		
		System.out.println("Final term : "+finalTerm);
		
		return finalTerm.substring(finalTerm.length()-lastNoOfDigits,finalTerm.length());
	}
	
	public static void main(String[] args) {
		
		int lastNoOfDigits=10;
		int n=1000;
		
		P48_SelfPowers p48_SelfPowers = new P48_SelfPowers();
		System.out.println("Last "+lastNoOfDigits+" Digits of sum of powers upto to "+n+" is : "+p48_SelfPowers.getLastNTermsOfPowerN(n, lastNoOfDigits));

//		System.out.println("findPowerOf(2,2) "+p48_SelfPowers.findPower(2, 2));
		
	}

}
