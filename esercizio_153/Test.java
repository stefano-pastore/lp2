import java.util.List;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		List<Integer> l = new LinkedList<Integer>();
		l.add(10);
		l.add(3);
		l.add(5);
		l.add(12);
		l.add(11);
		l.add(35);

		for (Integer i : new IncreasingSubSeq<Integer>(l))
		{
			System.out.println(i);
		}

	}

}
