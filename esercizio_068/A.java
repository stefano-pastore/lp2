class A
{
	public String f(B x, Object y) { return f(x,x); }
	public String f(B x, A y) { return "A2"; }
}