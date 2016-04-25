class ResettableSafe extends Safe
{
	public ResettableSafe(Integer key, String secret)
	{
		super(key, secret);
	}

	public boolean changeKey(Integer old_key, Integer new_key)
	{
		if (this.attempts <= 0)
		{
			throw new RuntimeException();
		}
		else
		{
			boolean success = false;

			if (this.key == old_key)
			{
				this.key = new_key;
				success = true;
			}
			else
			{
				this.attempts -= 1;
			}

			return success;
		}
	}
}