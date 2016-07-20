public class MutexWithLog
{
	private Boolean lock;
	private Thread currentThread;

	public MutexWithLog()
	{
		this.lock = new Boolean(false);
		this.currentThread = null;
	}

	public void lock()
	{
		synchronized (this)
		{
			while (this.lock)
			{
				try
				{
					this.wait();
				} 
				catch (InterruptedException ie)
				{
					ie.getMessage();
				}
			}

			this.lock = true;
			this.currentThread = Thread.currentThread();
			System.out.println(this.currentThread.getName() + " ha acquisito il lock.");

		}
	}

	public void unlock()
	{
		synchronized (this)
		{
			if (this.lock)
			{
				if (this.currentThread.equals(Thread.currentThread()))
				{
					this.lock = false;
					this.currentThread = null;
					this.notifyAll();
					System.out.println(Thread.currentThread().getName() + " ha rilasciato il lock.");
				} 
				else
				{
					throw new RuntimeException();
				}
			}
		}
	}
}
