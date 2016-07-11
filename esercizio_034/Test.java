class Test
{
	public static void main(String[] args)
	{
		B beta = new B();
		A alfa = beta;

		System.out.println(alfa.f(alfa, alfa, null));
		System.out.println(beta.f(alfa, beta, beta));
		System.out.println(beta.f(beta, beta, beta));
		System.out.println(beta.f(alfa, alfa, alfa));
	}
}