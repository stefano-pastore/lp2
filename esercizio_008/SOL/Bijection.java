import java.util.Map;
import java.util.HashMap;

class Bijection<T, U>
{
	private final Map<T,U> domain;
	private final Map<U,T> codomain;

	public Bijection()
	{
		domain = new HashMap<>();
		codomain = new HashMap<>();
	}

	public void addPair(T key, U value)
	{
		if (!domain.containsValue(value) && !domain.containsKey(key))
		{
			domain.put(key, value);
			codomain.put(value, key);
		}
		else
		{
			throw new RuntimeException();
		}
	}

	public U getValue(T key)
	{
		return domain.get(key);
	}

	public T getKey(U key)
	{
		return codomain.get(key);
	}
}