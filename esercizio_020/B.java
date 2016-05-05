class B extends A
{
	public String f(A a, B b) { return "2"; }
	public int f(B c, C b) { return 3; };
	public int f(C c, Object x) { return 4; }
}