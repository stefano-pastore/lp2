class Test
{
	public static void main(String[] args)
	{
		MyString a = new MyString("freddo");
		MyString b = new MyString("defro");
		MyString c = new MyString("caldo");

		MyString d = c.clone();

		System.out.println(a.equals(b));
		System.out.println(b.equals(c));
		System.out.println(a.hashCode() == b.hashCode());
	}
}