import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Test
{
	public static void main(String[] args)
	{
		Set<Integer> x = new HashSet<Integer>();
		x.add(1);
		x.add(2);
		x.add(5);

		Selector<Integer> oddSelector = new Selector<Integer>() {
			public boolean select(Integer n)
			{
				return ((n % 2) != 0);
			}
		};

		Set<Integer> y = concurrentFilter(x, oddSelector);

		for (Integer n : y)
		{
			System.out.println(n + " ");
		}
	}

	public static <T, S extends T> Set<S> concurrentFilter(Set<S> set, Selector<T> selector)
	{
		final Set<S> filteredSet = new HashSet<S>();
		Iterator<S> setIterator = (Iterator<S>) set.iterator();
		while (setIterator.hasNext())
		{
			final S next_element = setIterator.next();

			Thread t = new Thread() 
			{
				public void run()
				{
					if (selector.select(next_element))
					{
						filteredSet.add(next_element);
					}
				}

			};
			t.start();
			try
			{
				t.join();
			} catch (InterruptedException e)
			{

				e.printStackTrace();
			}
		}

		return filteredSet;
	}
}
