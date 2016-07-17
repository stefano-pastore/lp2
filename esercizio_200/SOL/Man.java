
class Man extends Person
{
	
	public Man(String firstName, String lastName)
	{
		super(firstName, lastName);
		this.spouse = null;
	}
	
	protected void setSpouse(Person p) { this.spouse = p; }
	
	public void marries(Person p)
	{
		if (p instanceof Man)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			Woman w = (Woman) p;
			if (p.getSpouse() == null)
			{
				this.spouse = p;
				w.setSpouse(this);
			}
		}
	}
}
