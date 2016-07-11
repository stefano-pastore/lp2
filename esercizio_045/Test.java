import java.util.Comparator;

class Test
{
	public static void main(String[] args)
	{
		DataSeries pop1 = new DataSeries();
		DataSeries pop2 = new DataSeries();
		pop1.set(2000, 15000.0); pop1.set(2005, 18500.0); pop1.set(2010, 19000.0);
		pop2.set(2000, 12000.0); pop2.set(2005, 16000.0); pop2.set(2010, 21000.0);

		Comparator<DataSeries> c2005 = DataSeries.comparatorByYear(2005);
		Comparator<DataSeries> c2010 = DataSeries.comparatorByYear(2010);
		
		System.out.println(c2005.compare(pop1, pop2));
		System.out.println(c2010.compare(pop1, pop2));
	}
}
