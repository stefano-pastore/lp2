class A
{
	public int f(int a, float b, double c) { return 1; }
	public int f(double a, double b, double c) { return 2; }
	private int f(int a, double b, double c) { return 3; }
}