import java.util.Map;
import java.util.Set;
import java.util.HashMap;

class BoundedMap<S,T>
{
	private final Map<S,T> map;
	private final Map<S, Integer> visits;
	private final Integer size;
	
	public BoundedMap(Integer size)
	{
		if (size <= 0)
		{
			throw new RuntimeException();
		}
		
		this.size = size;
		map = new HashMap<S,T>();
		visits = new HashMap<S, Integer>();
	}
	
	private S getLeastVisited()
	{
		Set<S> keySet = visits.keySet();
		Integer value = 0;
		S mapKey = null;
		
		for (S key : keySet)
		{
			Integer numberOfVisits = visits.get(key);
			if ((mapKey == null) || (value >= numberOfVisits))
			{
				mapKey = key;
				value = numberOfVisits;
			}
		}
		
		return mapKey;
	}
	
	public void put(S key, T value)
	{
		if (map.size() >= this.size)
		{
			S leastVisitedKey = this.getLeastVisited();
			map.remove(leastVisitedKey);
			visits.remove(leastVisitedKey);
		}

		map.put(key, value);
		visits.put(key, 0);
	}
	
	public T get(S key)
	{
		if (map.containsKey(key))
		{
			visits.replace(key, visits.get(key)+1);
			return map.get(key);
		}
		
		return null;
	}
}