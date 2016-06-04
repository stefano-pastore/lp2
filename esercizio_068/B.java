class B extends A
{
	public String f(B x, Object y) { return f(x,x); }
	private String f(B x, B y) { return "B2"; }
	public String f(B x, A y) { return "B3"; }
}