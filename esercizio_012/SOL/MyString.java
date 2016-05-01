class MyString
{
	private String s;

	public MyString(String s)
	{
		this.s = s;
	}

	@Override
	public String toString() { return s; }

	//clone
	@Override 
	public MyString clone()
	{
		MyString str = null;
		str = new MyString(this.toString());
		return str;
	}

	// equals
	@Override
	public boolean equals(Object x)
	{
		if (!(x instanceof MyString)) return false;

		MyString myString = (MyString) x;

		String s1;
		String s2;

		if (s.length() >= myString.toString().length())
		{
			s1 = s;
			s2 = myString.toString();
		}
		else
		{
			s1 = myString.toString();
			s2 = s;
		}

		int i = 0;
		boolean allContained = true;

		while ((i < s1.length()) && (allContained))
		{
			String current_char = String.valueOf(s1.charAt(i));
			if (!(s2.contains(current_char)))
			{
				allContained = false;
			}

			i++;
		}

		return allContained;
	}

	// hashcode
	@Override
	public int hashCode()
	{
		int code = 0;

		for (int i = 0; i < s.length(); i++)
		{
			if (s.lastIndexOf(s.charAt(i)) == i)
			{
				code += (String.valueOf(s.charAt(i))).hashCode();
			}
		}

		return code;
	}
}