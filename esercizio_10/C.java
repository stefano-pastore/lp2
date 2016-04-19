class C extends B
{
	public String f(A x, A y) { return "C1: " + y.f(y, null); }
}
