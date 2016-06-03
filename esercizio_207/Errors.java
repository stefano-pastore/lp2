import java.util.Map;

public class Errors
{
	private static int num = 7;
	private Integer z = 8;

	Map<Integer, Errors> m = new Map<Integer, Errors>();

	public Errors() {}

	private static class A 
	{
		private A()
		{
			num += z;
		}
	}

	private void f()
	{
		m.put(7, new Errors() { public int g() { return 0; }});
	}

	public static final A a = new A();
}