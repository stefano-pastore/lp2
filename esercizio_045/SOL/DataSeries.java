import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;

public class DataSeries
{
	private Map<Integer, Double> data_map;
	
	public DataSeries()
	{
		data_map = new HashMap<Integer, Double>();
	}
	
	public void set(Integer year, Double value)
	{
		if (!data_map.containsKey(year))
		{
			data_map.put(year, value);
		}
		else
		{
			data_map.replace(year, value);
		}
	}
	
	public static Comparator<DataSeries> comparatorByYear(Integer year)
	{
		return new Comparator<DataSeries>()
		{
			public int compare(DataSeries seriesA, DataSeries seriesB)
			{
				return seriesA.getPopulation(year).compareTo(seriesB.getPopulation(year));
			}
		};
	}
	
	protected Double getPopulation(Integer year)
	{
		if (data_map.containsKey(year))
		{
			return data_map.get(year);
		}
		
		return Double.valueOf(0);
	}
}
