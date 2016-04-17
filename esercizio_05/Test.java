public class Test
{
	public static void main(String[] args)
	{
		C gamma = new C();
		B beta = gamma;
		A alfa = beta;

		System.out.println(beta.f(gamma, beta));
		System.out.println(gamma.f(beta, gamma));
	}
}