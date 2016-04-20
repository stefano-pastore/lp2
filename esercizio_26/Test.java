class Test
{
	public static void main(String[] args)
	{
		ResettableSafe s = new ResettableSafe(2, "L'assassino è il maggiordomo.");
		System.out.println(s.open(887313));
		System.out.println(s.open(12012));
		System.out.println(s.changeKey(12,34));
		System.out.println(s.open(2381313));
	}
}