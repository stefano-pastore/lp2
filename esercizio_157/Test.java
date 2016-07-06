public class Test
{
	public static void main(String[] args)
	{
		C gamma = new C();
		B beta = new B();
		A alfa = gamma;

		System.out.println(alfa.f(3.0, gamma));
		System.out.println(beta.f(3, beta));
		System.out.println(beta.f(3.0, null));
		System.out.println(gamma.f(3.0, gamma));
		System.out.println(true && (alfa == beta));
	}
}