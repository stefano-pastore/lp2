public class Test
{
	public static void main(String[] args)
	{
		final MutexWithLog m = new MutexWithLog();
		
		Thread t = new Thread("Secondo")
		{
			public void run()
			{
				m.lock();
				System.out.println("Due!");
				m.unlock();
			}
		};

		t.start();
		m.lock();
		System.out.println("Uno!");
		m.unlock();
	}
}
