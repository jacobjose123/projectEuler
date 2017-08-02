/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

import java.util.Calendar;
import java.util.Date;

/**
 * @author a-7383
 *
 */
public class P19_CountingSundays {
	
	private static int offSet;
	
	
	private static void updateOffSet(int newOffset)
	{
		if(offSet+newOffset<=7)
			offSet+=newOffset;
		else if(offSet==7)
			offSet = newOffset;
		else if(newOffset==2)
			offSet=1;
		
	}
	
	private static int countSundays(int startYear, int endYear)
	{
		int count =0;
		for(int year = startYear; year<=endYear;year++)
		{
			for(int month=0;month<12;month++)
			{
				
				Calendar date = Calendar.getInstance();
				date.set(year, month,1);
				
				if(date.get(Calendar.DAY_OF_WEEK)==1)
				{
					count++;
					System.out.println("Date : "+date.getTime()+"     Count : "+count);
					
				}
			}
			System.out.println("");
		}
		return count;
	}
	
	private static int countSundays2(int startYear,int endYear,int initialOffSet)
	{
		int count =0;
		offSet = initialOffSet;
		int newOffset=1;
		
		for(int year = startYear+1; year<=endYear;year++)
		{
			
			updateOffSet(newOffset);
			
			if(year%4==0)
				newOffset=2;
			else
				newOffset=1;
			
			Calendar c = Calendar.getInstance();
			c.set(year, 0, 1);
			
			if(offSet==1)
			{
				count++;
				if(c.get(Calendar.DAY_OF_WEEK)==1)
					System.out.println("Count : "+count+"     "+year+" : "+offSet+"    Day "+c.get(Calendar.DAY_OF_WEEK)+" 1st Jan "+year+" is a Sunday");
				else
					System.out.println("Count : "+count+"     "+year+" : "+offSet+"    Day "+c.get(Calendar.DAY_OF_WEEK));

					
			}	
			else
			{
				System.out.println("                 "+year+" : "+offSet+"    Day "+c.get(Calendar.DAY_OF_WEEK));
			}
			

			
			
			
			
			
			
		
		}
		return count;
	}

	public static void main(String[] args) {
		
		System.out.println("No of Sundays : "+countSundays(1901, 2000));

	}

}
