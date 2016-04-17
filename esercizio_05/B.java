class B extends A
{
	public String f(B x, C y) { return "B1: " + f(x,x); }
	public String f(B x, B y) { return "B2"; }
}