import java.util.Set;
import java.util.HashSet;

class Person
{
	final String firstName;
	final String lastName;
	final Set<Person> children;
	Person spouse;
	Person parentA;
	Person parentB;
	
	public Person(String firstName, String lastName)
	{
		if ((firstName == null) || (lastName == null))
		{
			throw new IllegalArgumentException();
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.spouse = null;
		this.parentA = null;
		this.parentB = null;
		this.children = new HashSet<Person>();
	}
	
	public boolean addChild(Person p)
	{
		p.setParent(this);
		if (this.getSpouse() != null)
		{
			p.setParent(this.getSpouse());
		}
		return children.add(p);
	}
	
	protected String getFirstName() { return this.firstName; }
	protected String getLastName() { return this.lastName; }
	protected Set<Person> getChildren() { return this.children; }
	protected Person getSpouse() { return this.spouse; }
	protected Person[] getParents() { Person[] parents = { this.parentA, this.parentB }; return parents;}
	protected void setParent(Person p) 
	{ 
		if ((parentA == null) && (parentB == null))
		{
			parentA = p;
		}
		else if ((parentA != null) && (parentB == null))
		{
			parentB = p;
		}
	}
	
	public int hashCode()
	{		
		int hashCode = 0;
		
		hashCode = this.firstName.hashCode() ^ this.lastName.hashCode();
		
		if (this.parentA != null) hashCode ^= this.parentA.getFirstName().hashCode();
		if (this.parentB != null) hashCode ^= this.parentB.getLastName().hashCode();
		if (this.spouse != null) hashCode ^= this.getSpouse().getFirstName().hashCode() ^ this.getSpouse().getLastName().hashCode();
		if (this.getChildren() != null) hashCode ^= this.getChildren().hashCode();

		return hashCode;
	}
	
	public void marries(Person p)
	{
		throw new UnsupportedOperationException();
	}
	
	public static boolean areSiblings(Person a, Person b)
	{
		if (a.equals(b))
		{
			return false;
		}
		
		Set<Person> offspring = new HashSet<Person>();
		Person[] parents = a.getParents();
		if (parents[0] != null)
		{
			offspring.addAll(parents[0].getChildren());
		}
		if (parents[1] != null)
		{
			offspring.addAll(parents[1].getChildren());
		}
		
		return (offspring.contains(b));
	}
}