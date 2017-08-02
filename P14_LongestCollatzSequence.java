/**
 * 
 *  @author jacobjose123
 * 
 */
package first25;

/**
 * @author a-7383
 *
 */
public class P14_LongestCollatzSequence implements Runnable 
{
	
	private  int startTerm = 1000000;
	private int endTerm = 999999;
	private long localChainCount;
	private static volatile long  maxChainCount;
	private static volatile long  maxChainTerm;

	
	public P14_LongestCollatzSequence(int startTerm, int endTerm) {
		super();
		this.startTerm = startTerm;
		this.endTerm = endTerm;
	}
	
	private synchronized void updateMaxChainCount(long term)
	{
		
		maxChainCount = localChainCount;
		maxChainTerm = term;
		

	}
	
	@Override
	public void run() {

		maxChainCount = 0;

		System.out.println("\n--------------------          " + startTerm+ "          --------------------");
		maxChainCount = returnChainCount(startTerm);
		localChainCount = maxChainCount;

		for (int i = startTerm - 1; i >= endTerm && localChainCount<100 ; i--) 
		{
			startTerm = i;
			System.out.println("\n--------------------          " + startTerm+ "          --------------------");
			localChainCount = returnChainCount(i);
			if (maxChainCount < localChainCount)
			{
				updateMaxChainCount(i);
			}
		}

		
	}
	private long isOdd(long term)
	{
		return (3*term+1);
	}
	
	private long isEven(long term)
	{
		return (term/2);
	}
	
	private   long returnChainCount(long term)
	{
		long chaincount =1;
		while(term>1)
		{
			System.out.println(term+"  LocalCount : "+chaincount+" MaxCount : "+maxChainCount+"   MaxTerm : "+maxChainTerm+"    CurrentTerm : "+startTerm);
			if(term%2==0)
				term = isEven(term);
			else
				term = isOdd(term);
			
			chaincount++;
		}
		System.out.println(term+"  LocalCount : "+chaincount+" MaxCount : "+maxChainCount+"   CurrentTerm : "+startTerm);

		return chaincount;
			
	}

	public static void main(String[] args) throws InterruptedException {
//		Thread t = new Thread(new LongestCollatzSequence(13,13));
		Thread [] t = new Thread[10];
		
//		for(int i=0,lowerBound=0, upperBound=100000 ;  i<10 ;  i++, lowerBound+=100000, upperBound+=100000 )
//		{
//			t[i]= new Thread(new LongestCollatzSequence(upperBound,lowerBound));
//			
//		}
//		
//		for(int i=0;i<10;i++)
//			t[i].start();

//		Thread [] t1 = new Thread[2];
//		t1[0]  = new Thread(new LongestCollatzSequence(13,13));
//		t1[1]  = new Thread(new LongestCollatzSequence(12,12));
//		
//		t1[0].start();
//		t1[1].start();
	
//		for(Thread t2:t)
//		{
//			t2.join();
//		}
		new Thread(new P14_LongestCollatzSequence(1000000,1)).start();
		
		
		System.out.println("\nMaximum Chain Count : "+maxChainCount);

	}

	

}
