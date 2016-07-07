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

		System.out.print("Elements: ");
		for (Integer n : y)
		{
			System.out.print(n + " ");
		}

	}

	public static <T, S extends T> Set<S> concurrentFilter(Set<S> set, Selector<T> selector)
	{
		final Set<S> filteredSet = new HashSet<S>();
		Iterator<S> setIterator = (Iterator<S>) set.iterator();
		while (setIterator.hasNext())
		{
			final S next_element = setIterator.next();

			Thread t = new Thread() {
				public void run()
				{
					System.out.println("Thread #" + this.getId() + " has been launched");

					synchronized (filteredSet)
					{
						if (selector.select(next_element))
						{
							System.out.println("The element " + next_element + " has been selected.");
							filteredSet.add(next_element);
						}
					}
				}

			};
			t.start();
			try
			{
				t.join();
			} 
			catch (InterruptedException e)
			{

				e.printStackTrace();
			}
		}

		return filteredSet;
	}
}
