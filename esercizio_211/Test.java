class Test
{
	public static void main(String[] args)
	{
		B beta = new B();
		A alfa1 = beta;
		A alfa2 = new A();

		System.out.println(alfa1.f(1,2,3));
		System.out.println(alfa2.f(1,2,3));
		System.out.println(beta.f(1.0,2,3));
		System.out.println(177 & 2);

	}
}