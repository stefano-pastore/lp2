import java.util.Map;

public class Errors
{
	private static int num = 7;
	private Integer z = 8;

	// Map è un'interfaccia e pertanto non è instanziabile.
	// Una delle possibili correzioni potrebbe essere ... = new HashMap<>();
	Map<Integer, Errors> m = new Map<Integer, Errors>();

	public Errors() {}

	private static class A 
	{
		// Non è possibile accedere a partire da un contesto statico
		// ad una variabile che non è statica. Una possibile soluzione
		// potrebbe essere dichiarare la variabile z come static.
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