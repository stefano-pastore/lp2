class B extends A
{
	public String f(B x, A y) { return "B1: " + y.f(y,y); }
	public String f(A x, A y) { return "B2"; }
}
