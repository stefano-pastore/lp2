class Test
{
	public static void main(String args[])
	{
		double a1[] = {1,2,3};
		double a2[] = {2,2};

		Polynomial p1 = new Polynomial(a1);
		Polynomial p2 = new Polynomial(a2);
		Polynomial p3 = p2.times(p1);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
}