class Test
{
	public static void main(String[] args)
	{
		B beta = new B();
		A alfa = beta;
		A gamma = new A();

		System.out.println(alfa.f(beta, "ciao"));
		System.out.println(beta.f(beta, new A[10]));
		System.out.println( (1 == 2) || (7 >= 7));

		System.out.println(gamma.f(beta, new Object()));
	}
}