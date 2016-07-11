import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class BoundedSet<E>
{
	private List<E> refs;
	private Set<E> boundedSet;
	private Integer fixedSize;
	
	public BoundedSet(Integer n)
	{
		this.fixedSize = n;
		refs = new ArrayList<E>();
		boundedSet = new HashSet<E>();
	}
	
	public boolean add(E e)
	{
		if (!boundedSet.contains(e))
		{
			if (boundedSet.size() >= this.fixedSize)
			{
				E element = refs.get(0);
				boundedSet.remove(element);
				refs.remove(0);
			}
			
			refs.add(refs.size(), e);
			return boundedSet.add(e);
		}
		
		return false;
	}
	
	public boolean contains(E e)
	{
		return boundedSet.contains(e);
	}
	
	public int size()
	{
		return boundedSet.size();
	}
}
