import java.util.Set;
import java.util.Iterator;

class RunOnSet<T> extends Thread
{
	private final RunnableWithArg<T> runnable;
	private final Set<? extends T> set;

	public RunOnSet(RunnableWithArg<T> r, Set<? extends T> s)
	{
		runnable = r;
		set = s;
	}

	public void run()
	{
		Iterator<? extends T> iterator = set.iterator();

		while (iterator.hasNext())
		{
			final T n = iterator.next();

			new Thread() {

				public void run() 
				{
					runnable.run(n);
				}

			}.start();
		}
	}
}