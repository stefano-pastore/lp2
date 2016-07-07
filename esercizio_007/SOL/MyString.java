import java.util.Map;
import java.util.HashMap;

class MyString implements Cloneable
{
	private final String str;
	
	public MyString(String str)
	{
		this.str = str;
	}
	
	@Override
	public MyString clone()
	{
		MyString clone = null;
		try
		{
			clone = (MyString) super.clone();
		} 
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return clone;
	}
	
	@Override
	public boolean equals(Object x)
	{
		if (!(x instanceof MyString))
			return false;
		
		MyString string = (MyString) x;
		Map<String, Integer> localString = this.getMapped();
		Map<String, Integer> extString = string.getMapped();
		
		return localString.equals(extString);
	}
	
	protected Map<String, Integer> getMapped()
	{
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for (int i = 0; i < this.str.length(); i++)
		{
			String ch = String.valueOf(this.str.charAt(i));
			if (!hm.containsKey(ch))
			{
				hm.put(ch, 1);
			}
			else
			{
				Integer value = hm.get(ch);
				hm.replace(ch, value+1);
			}
		}

		return hm;
	}
	
	@Override
	public int hashCode()
	{
		int hash = 0;

		for (int i = 0; i < this.str.length(); i++)
		{
			hash ^= String.valueOf(this.str.charAt(i)).hashCode();
		}
		
		return hash;
	}
}
