import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConcatIterator
{
	<S> Iterator<S> concat(Iterator<? extends S> a, Iterator<? extends S> b)
	{
		return new Iterator<S>()
		{
			@Override
			public boolean hasNext()
			{
				return (a.hasNext() || b.hasNext());
			}
			
			@Override
			public S next()
			{
				if (a.hasNext()) return a.next();
				if (b.hasNext()) return b.next();
				throw new NoSuchElementException();
			}
			
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		};
	}
}
