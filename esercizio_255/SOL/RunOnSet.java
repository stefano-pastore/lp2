import java.util.Set;
import java.util.Iterator;

class RunOnSet extends Thread
{
	private RunnableWithArg<Integer> runnable;
	private Set<Integer> set;

	public RunOnSet(RunnableWithArg<Integer> r, Set<Integer> s)
	{
		runnable = r;
		set = s;
	}

	public void run()
	{
		Iterator<Integer> iterator = set.iterator();

		while (iterator.hasNext())
		{
			Integer n = iterator.next();

			new Thread() {

				public void run() 
				{
					runnable.run(n);
				}

			}.start();
		}
	}
}