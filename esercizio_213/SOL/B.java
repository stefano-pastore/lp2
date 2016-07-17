class B
{
	public static int x;

	public B() {}

	public static A copia(B b)
	{
		return new A();
	}

	public static B copia(int i)
	{
		return new B();
	}

	public int g()
	{
		return 0;
	}
}