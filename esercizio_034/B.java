class B extends A
{
	public String f(A x, A y, B z) { return "B1"; }
	public String f(A x, Object y, A z) { return "B2"; }
	public String f(A x, Object y, B z) { return "B3"; }
}