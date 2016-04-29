class Test
{
	public static void main(String[] args)
	{
		Container a = new Container();
		Container b = new Container();
		Container c = new Container();
		Container d = new Container();

		a.addWater(12);
		d.addWater(8);
		a.connect(b);

		System.out.println(a.getAmount() + " " + b.getAmount() + " "
			+ c.getAmount() + " " + d.getAmount());

		b.connect(c);
		System.out.println(a.getAmount() + " " + b.getAmount() + " "
			+ c.getAmount() + " " + d.getAmount());

		c.connect(d);
		System.out.println(a.getAmount() + " " + b.getAmount() + " "
			+ c.getAmount() + " " + d.getAmount());
	}
}