class Test
{
	public static void main(String[] args)
	{
		B[] beta = new C[10];
		A[] alfa = beta;
		beta[0] = new C();

		System.out.println(beta[0].f(beta, beta[0]));
		System.out.println(beta[0].f(alfa, beta[2]));
		System.out.println(beta[0].f(alfa, alfa[0]));
		System.out.println(6 & 7);
	}
}