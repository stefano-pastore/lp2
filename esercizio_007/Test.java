class Test
{
	public static void main(String[] args)
	{
		MyString a = new MyString("uno due tre");
		MyString b = new MyString("uno tre deu");
		MyString c = new MyString("ert unodue");
		
		MyString d = c.clone();
		
		System.out.println(a.equals(b));
		System.out.println(b.equals(c));
		System.out.println(a.hashCode() == b.hashCode());
	}
}
