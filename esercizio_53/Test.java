class Test
{
	public static void main(String[] args)
	{
		Box grande = new Box(20,30,40);
		Box grande2 = new Box(30,20,40);
		Box piccolo = new Box(10,10,50);

		System.out.println(grande.equals(grande2));
		System.out.println(grande.compareTo(piccolo));
		System.out.println(piccolo.fitsIn(grande));
	}
}
