package first26_50;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jacobjose123
 *
 */
public class P26_ReciprocalCycles {
	
	private static final int LIMIT = 1000;
	private static final int DIVIDENT=1;
	private static List<Integer> decimalDigits = new ArrayList<Integer>();
	
	private static void findDecimalDigits(int divident,int divisor)
	{
		if(divident%divisor==0)
		{
			decimalDigits.add(divident/divisor);
			return ;
		}
		
		if(divisor<=10)
			divident*=10;
		else if(divisor<=100)
			divident*=100;
		else if(divisor<=1000)
			divident*=1000;
		
		int quotient = divident/divisor;
		
		if( decimalDigits.contains(quotient) )
		{
			return;
		}
		else
		{
			decimalDigits.add(quotient);
		}
		
		if(divident%divisor>0)
			findDecimalDigits(divident%divisor,divisor);
		
		
		
		
			
	}
	
	private static int decimalDigitCount(int d)
	{
		BigDecimal quotientBD = new BigDecimal("1").divide(new BigDecimal(d));
		StringBuffer quotientSB = new StringBuffer(quotientBD.toPlainString());
		
		List<Character> quotientList= new ArrayList<Character>();
		
		quotientSB = new StringBuffer(quotientSB.substring(quotientSB.indexOf(".")+1, quotientSB.length()));
		
		System.out.println(quotientSB);
		
		for(int i=0;i<quotientSB.length();i++)
		{
			char quotient = quotientSB.charAt(i);
			if(quotient!=0 &&  !(quotientList.contains(quotient)) )
				quotientList.add(quotient);
		}
		
		
		return quotientList.size();
		
	}
	
	private static StringBuffer findQuotient(int divident,int divisor,int prevQuotient) throws Exception
	{
		if(divident%divisor==0)
			return new StringBuffer(String.valueOf((divident/divisor)));
		else if(divisor<=10)
			divident*=10;
		else if(divisor<=100)
			divident*=100;
		else
			divident*=1000;
		
		int quotient = divident/divisor;
		
		if(quotient==prevQuotient)
			return new StringBuffer(/*String.valueOf(prevQuotient)*/);
		else if(divident%divisor!=0 && prevQuotient==-1)
			return new StringBuffer(String.valueOf(quotient)+findQuotient(divident%divisor,divisor, quotient));
		else if(divident%divisor==0)
			return new StringBuffer(String.valueOf(quotient));
		else if(quotient!=prevQuotient)
			return new StringBuffer(String.valueOf(quotient)+findQuotient(divident%divisor,divisor, quotient));
		else 
			return new StringBuffer(/*String.valueOf(prevQuotient)+*/findQuotient(divident%divisor,divisor, quotient));
			
	}
	
	private static int maxReciprocalNumber(int limit) throws Exception
	{
		StringBuffer maxReciprocal = new StringBuffer();
		
		BigInteger b = new BigInteger("1");
		StringBuffer sb = new StringBuffer("");
		
		
		for(int d=1;d<limit;d++)
		{
			StringBuffer reciprocal = findQuotient(1,d, -1);
			if(reciprocal.length()>maxReciprocal.length())
				maxReciprocal = reciprocal;
			
			System.out.println("1/"+d+" = "+reciprocal+"     |    Max Reciprocal :"+maxReciprocal);
		}
		return maxReciprocal.length();
		
	}

	public static void main(String[] args) {

		
		
		int divisor=7;
		
		int divisorWithMaxDecimals = -1;
		int maxDecimals = -1;
		
		
		for(divisor=2;divisor<LIMIT;divisor++)
		{
			findDecimalDigits(DIVIDENT, divisor);
			System.out.print(DIVIDENT+"/"+divisor+" has "+decimalDigits.size()+" decimal digits \t");
			System.out.print(DIVIDENT+"/"+divisor+" = 0.");
			for(int decimalDigit:decimalDigits)
				System.out.print(decimalDigit);
			
			if(decimalDigits.size()>maxDecimals)
			{
				maxDecimals = decimalDigits.size();
				divisorWithMaxDecimals = divisor;
			}
			System.out.println("");
			decimalDigits.clear();
		}
		
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("d : "+divisorWithMaxDecimals);
		findDecimalDigits(DIVIDENT, divisorWithMaxDecimals);
		System.out.print(DIVIDENT+"/"+divisorWithMaxDecimals+" = 0.");
		for(int decimalDigit:decimalDigits)
			System.out.print(decimalDigit);
		
		
	}

}
