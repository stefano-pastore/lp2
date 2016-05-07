class Test
{
	public static void main(String[] argv)
	{
		Bijection<Integer,String> b = new Bijection<>();
		b.addPair(12, "dodici");
		b.addPair(7, "sette");
		System.out.println(b.getValue(12));
		System.out.println(b.getKey("tredici"));
		b.addPair(8, "sette");
	}	
}