class Test
{
	public static void main(String[] args)
	{
		MultiBuffer<Integer> mb = new MultiBuffer<Integer>(3);
		mb.insert(13);
		mb.insert(24);
		mb.insert(35);
		System.out.println(mb.take(0));
	}
}
