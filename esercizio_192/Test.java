import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class Test
{
	public static void main(String[] args)
	{
		List<Integer> l = new LinkedList<Integer>();
		l.add(3);
		l.add(4);
		l.add(177);

		Iterator<Integer> i = delayIterator(l.iterator(), 2);
		while (i.hasNext())
		{
			System.out.println(i.next());
		}
	}
}