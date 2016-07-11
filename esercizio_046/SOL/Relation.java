import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

class Relation<S,T>
{
	private Map<S, HashSet<T>> relations;
	
	public Relation()
	{
		relations = new HashMap<S, HashSet<T>>();
	}
	
	public void put(S key, T value)
	{
		HashSet<T> hs;
		
		if (!(relations.containsKey(key)))
		{
			hs = new HashSet<T>();
			hs.add(value);
			relations.put(key, hs);
		}
		else
		{
			hs = relations.get(key);
			hs.add(value);
			relations.replace(key, hs);
		}
	}
	
	public void remove(S key, T value)
	{
		if (relations.containsKey(key))
		{
			HashSet<T> hs = relations.get(key);
			hs.remove(value);
		}
	}
	
	public Set<T> image(S key)
	{
		if (relations.containsKey(key))
		{
			return relations.get(key);
		}
		
		return null;
	}
	
	public Set<S> preImage(T value)
	{
		Set<S> keyset = relations.keySet();
		Set<S> resultSet = new HashSet<S>();
			
		for (S elem : keyset)
		{
			HashSet<T> hs = relations.get(elem);
			if (hs.contains(value))
			{
				resultSet.add(elem);
			}
		}
		
		return resultSet;
	}
}
