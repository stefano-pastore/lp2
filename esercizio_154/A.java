class A
{
	private A a = new B.C(3);
	private double x = a.f(3);
	private B b = new B.D(3);
	
	private int f(int n)
	{
		g(new B(3), n);
		return 2*n;
	}
	
	private void g(A u, int z) {}
	private void g(B u, double z) {}
	
	public A(int i) {}
}
