import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class Test
{
	public static void main(String[] args)
	{
		List<Integer> l = new LinkedList<Integer>();
		l.add(3);
		l.add(4);
		l.add(177);

		Iterator<Integer> i = delayIterator(l.iterator(), 2);
		while (i.hasNext())
		{
			System.out.println(i.next());
		}
	}

	public static <T> Iterator<T> delayIterator(Iterator<T> iterator, Integer n)
	{
		return new Iterator<T>() 
		{
			public boolean hasNext()
			{
				return iterator.hasNext();
			}

			public T next()
			{
				try
				{
					Thread.sleep(n * 1000);
				}
				catch (InterruptedException e)
				{
					System.err.println(e.getMessage());
				}
				return iterator.next();
			}

			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		};
	}
}