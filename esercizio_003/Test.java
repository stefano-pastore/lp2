import java.util.Set;
import java.util.HashSet;

class Test
{
	public static void main(String[] args)
	{
		Set<Integer> x = new HashSet<Integer>();
		x.add(1); x.add(2); x.add(5);

		
		Selector<Integer> oddSelector = new Selector<Integer>()
		{
			public boolean select(Integer n)
			{
				return ((n % 2) != 0);
			}
		};
		
		Set<Integer> y = concurrentFilter(x, oddSelector);
		
		for (Integer n : y)
		{
			System.out.println(n);
		}
	}
}
