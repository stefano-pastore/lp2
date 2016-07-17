class Woman extends Person
{
	public Woman(String firstName, String lastName)
	{
		super(firstName, lastName);
		this.spouse = null;
	}
	
	protected void setSpouse(Person p) { this.spouse = p; }
	
	public void marries(Person p)
	{
		if (p instanceof Woman)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			if (p.getSpouse() == null)
			{
				this.spouse = p;
			}
		}
	}
}
