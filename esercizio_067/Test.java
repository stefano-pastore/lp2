class Test
{
	public static void main(String[] args)
	{
		Segment s1 = new Segment(0.0, -3.0, 4.0, 0.0);
		Segment s2 = new Segment(4.0, 0.0, 0.0, -3.0);

		Segment s3 = s2.clone();
		System.out.println(s1.equals(s2));
		System.out.println(s1.getDistance());
	}
}