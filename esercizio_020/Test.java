class Test
{
	public static void main(String[] args)
	{
		C gamma = new C();
		B beta = gamma;
		A alfa = gamma;

		System.out.println(alfa.f(beta, null));
		System.out.println(beta.f(beta, beta));
		System.out.println(beta.f(gamma, alfa));
		System.out.println(gamma.f(gamma, gamma));
		System.out.println((beta.getClass().getName()));
	}
}