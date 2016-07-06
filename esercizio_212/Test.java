class Test
{
	public static void main(String[] args)
	{
		Sorter<Integer> s = new Sorter<Integer>(7);

		System.out.println(s.check(4));
		System.out.println(s.check(1));
		System.out.println(s.check(6));
		System.out.println(s.check(6));
	}
}