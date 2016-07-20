import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class SuperclassIterator implements Iterator<Class<?>>
{
	private Class<?> objClass;
	private List<Class<?>> classList;
	private Iterator<Class<?>> classIterator;
	
	public SuperclassIterator(Object x)
	{	
		this.objClass = x.getClass();
		classList = this.getSuperclasses(this.objClass);
		classIterator = classList.iterator();
	}
	
	private List<Class<?>> getSuperclasses(Class<?> c)
	{
		Class<?> currentClass = c;
		List<Class<?>> list = new ArrayList<Class<?>>();
		
		while (currentClass != null)
		{
			list.add(currentClass);
			currentClass = currentClass.getSuperclass();
		}
		return list;
	}

	@Override
	public boolean hasNext()
	{
		return classIterator.hasNext();
	}

	@Override
	public Class<?> next()
	{
		return classIterator.next();
	}
	
	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}

}
