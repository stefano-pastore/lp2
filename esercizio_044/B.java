class B extends A
{
	public String f(Object x, B y) { return "B1 + " + f(y, null); }
	public String f(B[] x, C y) { return "B2"; }
}