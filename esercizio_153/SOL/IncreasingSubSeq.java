import java.util.List;
import java.util.Iterator;
import java.lang.Iterable;

public class IncreasingSubSeq<T extends Comparable<T>> implements Iterable<T>
{
	private List<T> list;
	private Integer elements_no;

	public IncreasingSubSeq(List<T> l)
	{
		list = l;
		elements_no = getElements();
	}

	private Integer getElements()
	{
		Integer n = 0;
		T predecessor = null;
		Iterator<T> list_iterator = list.iterator();

		while (list_iterator.hasNext())
		{
			T next_element = list_iterator.next();
			if ((predecessor == null) || (predecessor.compareTo(next_element) < 0))
			{
				predecessor = next_element;
				n++;
			}
		}

		return n;
	}
	
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			private T predecessor = null;
			private T current_element = null;
			private Integer remaining = 0;
			private Iterator<T> list_iterator = list.iterator();

			public boolean hasNext()
			{
				return (remaining < elements_no);
			}

			public T next()
			{
				while (list_iterator.hasNext())
				{
					current_element = list_iterator.next();
					if ((predecessor == null) || (predecessor.compareTo(current_element) < 0))
					{
						predecessor = current_element;
						remaining++;
						return current_element;
					}
				}

				return null;
			}

			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		};
	}
}