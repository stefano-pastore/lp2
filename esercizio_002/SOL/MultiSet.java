import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class MultiSet<T> implements Iterable<T>
{
	private List<T> multiset;
	
	public MultiSet()
	{
		multiset = new ArrayList<T>();
	}
	
	public void add(T x)
	{
		multiset.add(x);
	}
	
	public void remove(T x)
	{
		multiset.remove(x);
	}
	
	protected List<T> getSet()
	{
		return this.multiset;
	}
	
	public Iterator<T> iterator()
	{
		Iterator<T> i = multiset.iterator();
		
		return new Iterator<T>() {
			public boolean hasNext()
			{
				return i.hasNext();
			}
			
			public T next()
			{
				if (i.hasNext())
				{
					return i.next();
				}
				else
				{
					throw new NoSuchElementException();
				}
			}
			
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public boolean equals (Object o)
	{
		if (!(o instanceof MultiSet<?>))
		return false;
		
		MultiSet<?> ms = (MultiSet<?>) o;
		
		HashMap<T, Integer> localms = this.getMapped();
		HashMap<?, Integer> extms = ms.getMapped();
		
		return localms.equals(extms);
	}
	
	protected HashMap<T, Integer> getMapped()
	{
		HashMap<T, Integer> map = new HashMap<T, Integer>();
		
		for (T x : this.multiset)
		{
			if (!(map.containsKey(x)))
			{
				map.put(x, 1);
			}
			else
			{
				Integer value = map.get(x);
				map.replace(x,value+1);
			}
		}
		
		return map;
	}
}
