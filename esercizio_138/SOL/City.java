import java.util.Set;
import java.util.HashSet;

public class City
{
	private final String name;
	private Set<City> connectedCities;
	
	public City(String name)
	{
		this.name = name;
		this.connectedCities = new HashSet<City>();
	}
	
	protected boolean isDirectlyConnectedTo(City c, Set<City> excluded)
	{
		if (this.connectedCities.contains(c))
		{
			return true;
		}
		else
		{
			if (excluded == null)
			{
				excluded = new HashSet<City>();
			}
			excluded.add(this);
			
			for (City city : connectedCities)
			{
				if (!excluded.contains(city))
				{
					return city.isDirectlyConnectedTo(c, excluded);
				}
			}
			
			return false;
		}
	}
	
	public boolean isConnected(City c)
	{
		return this.isDirectlyConnectedTo(c, null);
	}
	
	public void connect(City c)
	{
		this.directlyConnectTo(c);
		c.directlyConnectTo(this);
	}
	
	protected void directlyConnectTo(City c)
	{
		this.connectedCities.add(c);
	}
	
	public Set<City> getConnections()
	{
		return this.connectedCities;
	}
	
	public String toString() 
	{
		return this.name;
	}
}
