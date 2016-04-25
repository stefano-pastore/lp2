class Safe 
{
	protected String secret;
	protected Integer key;
	protected int attempts;

	public Safe(Integer key, String secret)
	{
		this.secret = secret;
		this.key = key;
		this.attempts = 3;
	}

	public String open(Integer key)
	{
		if (this.attempts > 0)
		{
			String secret;

			if (this.key == key)
			{
				this.attempts = 3;
				secret = this.secret;
			}
			else
			{
				this.attempts -= 1;
				secret = null;
			}

			return secret;
		}
		else
		{
			throw new RuntimeException();
		}			
	}
}