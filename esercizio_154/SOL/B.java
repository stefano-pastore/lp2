public class B extends A
{
	public B(int x) 
	{
		super(x);
	}
	
	private void g(B u, int z) {}
	
	public static double f(int x)
	{
		return Double.valueOf(x);
	}
	
	public static class C extends A
	{
		private Integer x;
		
		public C(Integer x)
		{
			super(x);
		}
	}
	
	public static class D extends B
	{
		private Integer x;
		
		public D(Integer x)
		{
			super(x);
		}
	}
}
