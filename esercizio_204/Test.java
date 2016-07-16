class Test
{
	public static void main(String[] args)
	{
		Rational n = new Rational(2, 12);
		Rational m = new Rational(4, 15);
		Rational o = n.plus(m);
		Rational p = n.times(m);
		
		System.out.println(n);
		System.out.println(o);
		System.out.println(p);
	}
}
