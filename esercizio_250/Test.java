public class Test
{
	public static void main(String[] args)
	{
		B beta = new B();
		A alfa = beta;

		//System.out.println(alfa.f(1,2,3));
		// System.out.println(alfa.f(1,2,3.0));
		 System.out.println(beta.f(true, 5, 6));
		// System.out.println(beta.f(false, 3.0, 4));
		// System.out.println(7 & 5);
	}
}