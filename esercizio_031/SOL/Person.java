import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Person
{
	private final String name;
	private final List<Person> friends;
	private final List<Person> enemies;

	public Person(String n)
	{
		name = n;
		friends = new ArrayList<Person>();
		enemies = new ArrayList<Person>();
	}

	public void addEnemy(Person p)
	{
		if ((!(p.equals(this))) && (!(friends.contains(p))))
		{
			enemies.add(p);
		}
	}

	public void addFriend(Person p)
	{
		if ((!(p.equals(this))) && (!(enemies.contains(p))))
		{
			friends.add(p);
		}
	}

	public String toString()
	{
		return name;
	}

	protected List<? extends Person> getFriends()
	{
		return friends;
	}

	protected List<? extends Person> getEnemies()
	{
		return enemies;
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Person)) return false;
		Person p = (Person) o;

		return (name.equals(p.toString()) 
				&& friends.equals(p.getFriends()) 
					&& enemies.equals(p.getEnemies()));
	}

	public Iterable<Person> contacts()
	{
		return new Iterable<Person>() 
		{
			public Iterator<Person> iterator()
			{
				return new Iterator<Person>()
				{
					Iterator<Person> f = friends.iterator();
					Iterator<Person> e = enemies.iterator();

					public boolean hasNext()
					{
						return (f.hasNext() || e.hasNext());
					}

					public Person next()
					{
						if (f.hasNext())
						{
							return f.next();
						}
						else if (e.hasNext())
						{
							return e.next();
						}
						else
						{
							throw new NoSuchElementException();
						}
					}

					public void remove()
					{
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}