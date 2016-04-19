public class Test
{
	public static void main(String[] args)
	{
		C gamma = new C();
		B beta = gamma;
		A alfa = new A();

		System.out.println(beta.f(gamma, alfa));
		System.out.println(gamma.f(alfa, alfa));
	}
}
