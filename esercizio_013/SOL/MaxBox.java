import java.util.Comparator;

class MaxBox<T>
{
	private T max_value;
	private Comparator<T> comparator;

	public MaxBox()
	{
		max_value = null;
		comparator = null;
	}

	public MaxBox(Comparator<T> c)
	{
		max_value = null;
		comparator = c;
	}

	public T getMax()
	{
		return max_value;
	}

	public void insert(T value)
	{
		if (max_value == null)
		{
			max_value = value;
		}
		else
		{
			if (comparator != null)
			{
				if (comparator.compare(max_value, value) < 0)
				{
					max_value = value;	
				}
			}
			else if (max_value instanceof Comparable)
			{
				Comparable max = (Comparable) max_value;
				if (max.compareTo(value) < 0)
				{
					max_value = value;
				} 		
			}
			else
			{
				throw new RuntimeException();
			}
		}
	}	
}
