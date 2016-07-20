import java.util.Iterator;
import net.foglioinbianco.lp2.*;

class Test
{
	public static void main(String[] args)
	{
		Iterator<Class<?>> i = new SuperclassIterator(new Manager("Franco"));
		while (i.hasNext())
		{
			System.out.println(i.next());
		}
	}
}
