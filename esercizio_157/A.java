class A
{
	public String f(double n, Object x) { return "A1"; }
	public String f(double n, A x) { return "A2"; }
	public String f(int n, Object x) { return "A3"; }
}