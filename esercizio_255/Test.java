import java.util.Set;
import java.util.HashSet;

class Test
{
	public static void main(String[] args)
	{
		Set<Integer> s = new HashSet<Integer>();
		s.add(3);
		s.add(13);
		s.add(88);

		RunnableWithArg<Integer> r = new RunnableWithArg<Integer>() {
			public void run(Integer i)
			{
				System.out.println(i/2);
			}
		};

		Thread t = new RunOnSet<Integer>(r,s);
		t.start();
	}
}