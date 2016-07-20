import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class Test
{
	public static void main(String[] args)
	{
		List<Integer> iList = new ArrayList<Integer>();
		List<String> sList = new ArrayList<String>();
		
		iList.add(1); iList.add(4); iList.add(5);
		sList.add("Hello"); sList.add("World"); sList.add("!");

		Iterator<Object> listIterator = new ConcatIterator().concat(iList.iterator(), sList.iterator());
		
		while (listIterator.hasNext())
		{
			System.out.println(listIterator.next());
		}
	}
}
