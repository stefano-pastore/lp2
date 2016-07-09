public class Test
{
	private static volatile Integer winner;
	
	public static void main(String[] args)
	{
		ThreadRunnable r1;
		ThreadRunnable r2;
		
		r1 = new ThreadRunnable(1);
		r2 = new ThreadRunnable(2)
		threadRace(r1, r2);
		
		if (winner != null)
		{
			System.out.println(winner);
		}
		else
		{
			System.err.println("Qualcosa è andato verameeeeeeeente storto!");
		}
	}
	
	public static void threadRace(Runnable r1, Runnable r2)
	{
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		try
		{
			t1.join();
			t2.join();
		}
		catch (InterruptedException ie)
		{
			System.err.println(ie.getMessage());
			return;
		}
	}
	
	public static class ThreadRunnable implements Runnable
	{
		private Integer id;
		private Integer size;
		
		public ThreadRunnable(Integer id)
		{
			this.id = id;
		}
		
		@Override
		public void run()
		{
			for (int i = 0; i < 1E6; i++)
			{
				// do nothing
			}
			
			if (winner == null)
			{
				winner = new Integer(id);
			}
		}
	}
}
