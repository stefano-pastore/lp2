class C extends B
{
	public String f(A[] x, A y) { return "C1 + " + f(null, y); }
	public String f(B[] x, C y) { return "C2"; }
}